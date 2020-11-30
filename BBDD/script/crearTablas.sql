-- Crear todas las tablas
-- EQUIPO_MEDICO
CREATE TABLE EQUIPO_MEDICO (IDEQUIPO_MEDICO INT, NOMBRE VARCHAR(50), CONSTRAINT PK_EQUIPO_MEDICO PRIMARY KEY (IDEQUIPO_MEDICO));
-- MEDICO
CREATE TABLE MEDICO (IDMEDICO INT, NOMBRE varchar(20), APELLIDOS VARCHAR(40), EMAIL VARCHAR(50), ESPECIALIDAD VARCHAR (40), IDEQUIPO_MEDICO INT, DIASDISPONIBLES INT, CONSTRAINT PK_MEDICO PRIMARY KEY (IDMEDICO), CONSTRAINT FK_MEDICO_EQUIPO_MEDICO FOREIGN KEY (IDEQUIPO_MEDICO) REFERENCES EQUIPO_MEDICO);
-- MEDICO SUSTITUTO
CREATE TABLE MEDICOSUSTITUTO (IDMEDICOSUSTITUTO INT, NOMBRE varchar(20), APELLIDOS VARCHAR(40), EMAIL VARCHAR(50), CONSTRAINT PK_MEDICOSUSTITUTO PRIMARY KEY (IDMEDICOSUSTITUTO));
-- JORNADA_MEDICO
CREATE TABLE JORNADA_MEDICO (IDJORNADA_MEDICO INT, IDMEDICO INT, DIAS varchar(100), DIA_INICIO DATE, DIA_FIN DATE, HORA_INICIO VARCHAR(20), HORA_FIN VARCHAR(20), CONSTRAINT PK_JORNADA_MEDICO PRIMARY KEY (IDJORNADA_MEDICO), CONSTRAINT FK_JORNADA_MEDICO FOREIGN KEY (IDMEDICO) REFERENCES MEDICO);
-- VACACIONES_MEDICO
CREATE TABLE VACACIONES_MEDICO (IDVACACIONES_MEDICO INT, IDMEDICO INT, DIA_INICIO DATE, DIA_FIN DATE, CONSTRAINT PK_VACACIONES_MEDICO PRIMARY KEY (IDVACACIONES_MEDICO), CONSTRAINT FK_VACACIONES_MEDICO FOREIGN KEY (IDMEDICO) REFERENCES MEDICO);
-- VACACIONES_MEDICO_SOLICITADAS
CREATE TABLE VACACIONES_MEDICO_SOLICITADAS (IDVACACIONES_SOLICITADAS_MEDICO INT, IDMEDICO INT, DIA_INICIO DATE, DIA_FIN DATE, MOTIVO VARCHAR(50), NOMBREMEDICO VARCHAR(50), APROBADAS BOOLEAN, CANCELADAS BOOLEAN, ESPERANDO BOOLEAN, CONSTRAINT PK_VACACIONES_SOLICITADAS_MEDICO PRIMARY KEY (IDVACACIONES_SOLICITADAS_MEDICO), CONSTRAINT FK_VACACIONES__SOLICITADAS_MEDICO FOREIGN KEY (IDMEDICO) REFERENCES MEDICO);
-- ENFERMERO
CREATE TABLE ENFERMERO (IDENFERMERO INT, NOMBRE varchar(20), APELLIDOS VARCHAR(40), ESPECIALIDAD VARCHAR (40), IDEQUIPO_MEDICO INT, DIASDISPONIBLES INT, CONSTRAINT PK_ENFERMERO PRIMARY KEY (IDENFERMERO), CONSTRAINT FK_ENFERMERO_EQUIPO_MEDICO FOREIGN KEY (IDEQUIPO_MEDICO) REFERENCES EQUIPO_MEDICO);
-- JORNADA_ENFERMERO
CREATE TABLE JORNADA_ENFERMERO (IDJORNADA_ENFERMERO INT, IDENFERMERO INT, DIAS varchar(100), DIA_INICIO DATE, DIA_FIN DATE, HORA_INICIO VARCHAR(20), HORA_FIN VARCHAR(20), CONSTRAINT PK_JORNADA_ENFERMERO PRIMARY KEY (IDJORNADA_ENFERMERO), CONSTRAINT FK_JORNADA_ENFERMERO FOREIGN KEY (IDENFERMERO) REFERENCES ENFERMERO);
-- VACACIONES_ENFERMERO
CREATE TABLE VACACIONES_ENFERMERO (IDVACACIONES_ENFERMERO INT, IDENFERMERO INT, DIA_INICIO DATE, DIA_FIN DATE, CONSTRAINT PK_VACACIONES_ENFERMERO PRIMARY KEY (IDVACACIONES_ENFERMERO), CONSTRAINT FK_VACACIONES_ENFERMERO FOREIGN KEY (IDENFERMERO) REFERENCES ENFERMERO);
-- PACIENTE
CREATE TABLE PACIENTE (IDPACIENTE INT, DNI VARCHAR(9), NOMBRE varchar(20), APELLIDOS VARCHAR(40), EMAIL VARCHAR(50), TELEFONO VARCHAR(20), CONSTRAINT PK_PACIENTE PRIMARY KEY (IDPACIENTE));
-- HISTORIAL
CREATE TABLE HISTORIAL (IDHISTORIAL INT, IDPACIENTE INT, CONSTRAINT PK_HISTORIAL PRIMARY KEY (IDHISTORIAL), CONSTRAINT FK_HISTORIAL_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE);
-- UBICACION
CREATE TABLE UBICACION (IDUBICACION INT, NOMBRE VARCHAR(40), CONSTRAINT PK_UBICACION PRIMARY KEY (IDUBICACION));
-- HORARIO
CREATE TABLE HORARIO (IDHORARIO INT, HORA_INICIO VARCHAR(20), HORA_FIN VARCHAR(20), CONSTRAINT PK_HORARIO PRIMARY KEY (IDHORARIO));
-- CITA
CREATE TABLE CITA (IDCITA INT, IDPACIENTE INT, IDHORARIO INT, IDUBICACION INT, FECHA DATE, ASISTENCIA BOOLEAN, URGENTE BOOLEAN, INFOCONTACTO VARCHAR(200), NOMBREPACIENTE VARCHAR(50), MEDICOASIGNADO BOOLEAN, CONSTRAINT PK_CITA PRIMARY KEY (IDCITA), CONSTRAINT FK_CITA_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE, CONSTRAINT FK_CITA_HORARIO FOREIGN KEY (IDHORARIO) REFERENCES HORARIO, CONSTRAINT FK_CITA_UBICACION FOREIGN KEY (IDUBICACION) REFERENCES UBICACION);
-- CITAPROPUESTA
CREATE TABLE CITAPROPUESTA (IDCITAPROPUESTA INT, IDPACIENTE INT, IDHORARIO INT, IDUBICACION INT, FECHA DATE, URGENTE BOOLEAN, INFOCONTACTO VARCHAR(200), NOMBREPACIENTE VARCHAR(50), MEDICOASIGNADO BOOLEAN, PENDIENTEAPROBACION BOOLEAN, IDMEDICOPROPONER INT, CONSTRAINT PK_CITAPROPUESTA PRIMARY KEY (IDCITAPROPUESTA), CONSTRAINT FK_CITAPROPUESTA_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE, CONSTRAINT FK_CITAPROPUESTA_HORARIO FOREIGN KEY (IDHORARIO) REFERENCES HORARIO, CONSTRAINT FK_CITAPROPUESTA_UBICACION FOREIGN KEY (IDUBICACION) REFERENCES UBICACION);
-- CAUSA
CREATE TABLE CAUSA (IDCAUSA INT, IDCITA INT, IDPACIENTE INT, DESCRIPCION VARCHAR(100), CONSTRAINT PK_CAUSA PRIMARY KEY (IDCAUSA), CONSTRAINT FK_CAUSA_CITA FOREIGN KEY (IDCITA) REFERENCES CITA, CONSTRAINT FK_CAUSA_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE);
-- PRESCRIPCION
CREATE TABLE PRESCRIPCION (IDPRESCRIPCION INT, INSTRUCCION VARCHAR(100), HORA_ASIGNACION VARCHAR(20), DIA_ASIGNACION DATE, ES_MEDICAMENTO BOOLEAN, CONSTRAINT PK_PRESCRIPION PRIMARY KEY (IDPRESCRIPCION));
-- ANTECEDENTESCLINICOS
CREATE TABLE ANTECEDENTESCLINICOS (IDANTECEDENTESCLINICOS INT, DESCRIPCION VARCHAR(100), HORA_ASIGNACION VARCHAR(20), DIA_ASIGNACION DATE, CONSTRAINT PK_ANTECEDENTESCLINICOS PRIMARY KEY (IDANTECEDENTESCLINICOS));
-- MEDICAMENTO
CREATE TABLE MEDICAMENTO (IDMEDICAMENTO INT, IDPRESCRIPCION INT, NOMBRE VARCHAR(50), CANTIDAD INT, INTERVALO VARCHAR(20), DURACION VARCHAR(20), ANOTACION VARCHAR(50), CONSTRAINT PK_MEDICAMENTO PRIMARY KEY (IDMEDICAMENTO), CONSTRAINT FK_MEDICAMENTO_PRESCRIPCION FOREIGN KEY (IDPRESCRIPCION) REFERENCES PRESCRIPCION);

-- MEDICO_CITAS
CREATE TABLE MEDICO_CITAS (IDMEDICO INT, IDCITA INT, CONSTRAINT PK_MEDICO_CITA PRIMARY KEY (IDCITA,IDMEDICO), CONSTRAINT FK_MEDICO_CITA_MEDICO FOREIGN KEY (IDMEDICO) REFERENCES MEDICO, CONSTRAINT FK_MEDICO_CITA_CITA FOREIGN KEY (IDCITA) REFERENCES CITA);
-- MEDICO_CITASPROPUESTAS
CREATE TABLE MEDICO_CITASPROPUESTAS (IDMEDICO INT, IDCITAPROPUESTA INT, CONSTRAINT PK_MEDICO_CITAPROPUESTA PRIMARY KEY (IDCITAPROPUESTA,IDMEDICO), CONSTRAINT FK_MEDICO_CITAPROPUESTA_MEDICO FOREIGN KEY (IDMEDICO) REFERENCES MEDICO, CONSTRAINT FK_MEDICO_CITAPROPUESTA_CITAPROPUESTA FOREIGN KEY (IDCITAPROPUESTA) REFERENCES CITAPROPUESTA);
-- PRESCRIPCION_CITAS_PACIENTE
CREATE TABLE PRESCRIPCION_CITAS_PACIENTE (IDPRESCRIPCION INT, IDCITA INT, IDPACIENTE INT, CONSTRAINT PK_PRESCRIPION_CITAS_PACIENTE PRIMARY KEY (IDPRESCRIPCION,IDCITA,IDPACIENTE), CONSTRAINT FK_PRESCRIPCION_CITAS_PACIENTE_PRESCRIPCION FOREIGN KEY (IDPRESCRIPCION) REFERENCES PRESCRIPCION, CONSTRAINT FK_PRESCRIPCION_CITAS_PACIENTE_CITA FOREIGN KEY (IDCITA) REFERENCES CITA, CONSTRAINT FK_PRESCRIPCION_CITAS_PACIENTE_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE);
-- ANTECEDENTESCLINICOS_CITAS_PACIENTE
CREATE TABLE ANTECEDENTESCLINICOS_CITAS_PACIENTE (IDANTECEDENTESCLINICOS INT, IDCITA INT, IDPACIENTE INT, CONSTRAINT PK_ANTECEDENTESCLINICOS_CITAS_PACIENTE PRIMARY KEY (IDANTECEDENTESCLINICOS,IDCITA,IDPACIENTE), CONSTRAINT FK_ANTECEDENTESCLINICOS_CITAS_PACIENTE_ANTECEDENTESCLINICOS FOREIGN KEY (IDANTECEDENTESCLINICOS) REFERENCES ANTECEDENTESCLINICOS, CONSTRAINT FK_ANTECEDENTESCLINICOS_CITAS_PACIENTE_CITA FOREIGN KEY (IDCITA) REFERENCES CITA, CONSTRAINT FK_ANTECEDENTESCLINICOS_CITAS_PACIENTE_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE);
-- VACUNA
CREATE TABLE VACUNA (IDVACUNA INT, IDPACIENTE INT, NOMBREVACUNA VARCHAR(50), DIAASIGNADA DATE, DIAPUESTA DATE, HORAPUESTA VARCHAR(20), OBSERVACION VARCHAR(100), ISPUESTA BOOLEAN, CONSTRAINT PK_VACUNA PRIMARY KEY (IDVACUNA), CONSTRAINT FK_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE);
-- DIAGNOSTICO 
CREATE TABLE DIAGNOSTICO (ID_DIAGNOSTICO VARCHAR(5), IDPACIENTE INT, IDMEDICO INT, NOMBRE VARCHAR(250), CONSTRAINT PK_ID_DIAGNOSTICO PRIMARY KEY (ID_DIAGNOSTICO, IDPACIENTE), CONSTRAINT FK_DIAGNOSTICO_MEDICO FOREIGN KEY (IDMEDICO) REFERENCES MEDICO, CONSTRAINT FK_DIAGNOSTICO_PACIENTE FOREIGN KEY (IDPACIENTE) REFERENCES PACIENTE);
--EMFERMEDAD
CREATE TABLE EMFERMEDAD (ID_EMFERMEDAD INT, NOMBRE VARCHAR(1000), FECHA_INICIO DATE, FECHA_FIN DATE, ID_PACIENTE INT, SEGUIMIENTO BOOLEAN, CONSTRAINT PK_ID_EMFERMEDAD PRIMARY KEY (ID_EMFERMEDAD, ID_PACIENTE), CONSTRAINT FK_EMFERMEDAD_PACIENTE FOREIGN KEY (ID_PACIENTE) REFERENCES PACIENTE);
-- ENFERMERO_CITAS
CREATE TABLE ENFERMERO_CITAS (IDENFERMERO INT, IDCITA INT, CONSTRAINT PK_ENFERMERO_CITA PRIMARY KEY (IDCITA,IDENFERMERO), CONSTRAINT FK_ENFERMERO_CITA_ENFERMERO FOREIGN KEY (IDENFERMERO) REFERENCES ENFERMERO, CONSTRAINT FK_ENFERMERO_CITA_CITA FOREIGN KEY (IDCITA) REFERENCES CITA);
-- MEDICO SUSTITUTO
CREATE TABLE ENFERMEROSUSTITUTO (IDENFERMEROSUSTITUTO INT, NOMBRE varchar(20), APELLIDOS VARCHAR(40), EMAIL VARCHAR(50), CONSTRAINT PK_ENFERMEROSUSTITUTO PRIMARY KEY (IDENFERMEROSUSTITUTO));
-- VACACIONES_ENFERMERO_SOLICITADAS
CREATE TABLE VACACIONES_ENFERMERO_SOLICITADAS (IDVACACIONES_SOLICITADAS_ENFERMERO INT, IDENFERMERO INT, DIA_INICIO DATE, DIA_FIN DATE, MOTIVO VARCHAR(50), NOMBREENFERMERO VARCHAR(50), APROBADAS BOOLEAN, CANCELADAS BOOLEAN, ESPERANDO BOOLEAN, CONSTRAINT PK_VACACIONES_SOLICITADAS_ENFERMERO PRIMARY KEY (IDVACACIONES_SOLICITADAS_ENFERMERO), CONSTRAINT FK_VACACIONES__SOLICITADAS_ENFERMERO FOREIGN KEY (IDENFERMERO) REFERENCES ENFERMERO);
-- ENFERMERO_CITASPROPUESTAS
CREATE TABLE ENFERMERO_CITASPROPUESTAS (IDENFERMERO INT, IDCITAPROPUESTA INT, CONSTRAINT PK_ENFERMERO_CITAPROPUESTA PRIMARY KEY (IDCITAPROPUESTA,IDENFERMERO), CONSTRAINT FK_ENFERMERO_CITAPROPUESTA_ENFERMERO FOREIGN KEY (IDENFERMERO) REFERENCES ENFERMERO, CONSTRAINT FK_ENFERMERO_CITAPROPUESTA_CITAPROPUESTA FOREIGN KEY (IDCITAPROPUESTA) REFERENCES CITAPROPUESTA);

-- REGISTRO
CREATE TABLE REGISTRO (IDREGISTRO INT, FECHA DATETIME, DESCRIPCION VARCHAR(255), CONSTRAINT PK_REGISTRO PRIMARY KEY (IDREGISTRO));