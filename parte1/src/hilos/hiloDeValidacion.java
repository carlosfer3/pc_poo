@Override
public void run() {
    String codigo = txtCodigo.getText().trim();

    // 1. Validar existencia del trabajador
    if (!SistemaRegistro.getInstance().existeTrabajador(codigo)) {
        JOptionPane.showMessageDialog(null, "El trabajador con código " + codigo + " no está registrado.");
        return;
    }

    // 2. Obtener hora
    LocalTime horaAValidar;
    try {
        if (checkEditable.isSelected()) {
            int h = (Integer) spnHora.getValue();
            int m = (Integer) spnMinuto.getValue();
            horaAValidar = LocalTime.of(h, m);
        } else {
            horaAValidar = LocalTime.now();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al construir la hora: " + e.getMessage());
        return;
    }

    // 3. Determinar si es ingreso o salida según si existe un registro previo
    Registro registroExistente = SistemaRegistro.getInstance().buscarRegistroPorCodigo(codigo);

    if (registroExistente == null) {
        // 🟢 CASO: Ingreso
        LocalTime referencia = LocalTime.now(); // Hora actual como salida ficticia para validar

        if (!ValidadorHora.validarIngresoAntesDeSalida(horaAValidar, referencia)) {
            JOptionPane.showMessageDialog(null, "La hora de ingreso no puede ser posterior a la hora de salida (sistema).");
            return;
        }

        System.out.println("✓ Validación de ingreso exitosa para " + codigo);

    } else {
        // 🔵 CASO: Salida

        LocalTime horaIngreso = registroExistente.getHoraIngreso();
        if (horaIngreso == null) {
            JOptionPane.showMessageDialog(null, "Error: No se puede registrar salida sin haber registrado ingreso.");
            return;
        }

        if (!ValidadorHora.validarSalidaDespuesDeIngreso(horaIngreso, horaAValidar)) {
            JOptionPane.showMessageDialog(null, "La hora de salida debe ser posterior a la hora de ingreso.");
            return;
        }

        if (!ValidadorHora.validarSalidaDespuesDeHoraNormalIngreso(horaAValidar)) {
            JOptionPane.showMessageDialog(null, "La hora de salida no puede ser antes de la hora normal de ingreso.");
            return;
        }

        System.out.println("✓ Validación de salida exitosa para " + codigo);
    }
}
