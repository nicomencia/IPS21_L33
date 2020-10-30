--MEDICO (1000 - 1099)
INSERT INTO MEDICO (IDMEDICO, NOMBRE, APELLIDOS, EMAIL) VALUES ('1000', 'JOSE', 'GUTIERREZ PRADOS', 'jpjose@gmail.com');
INSERT INTO MEDICO (IDMEDICO, NOMBRE, APELLIDOS, EMAIL) VALUES ('1001', 'ANDRES', 'ORTIZ GARRIDO', 'aortiz@gmail.com');
INSERT INTO MEDICO (IDMEDICO, NOMBRE, APELLIDOS, EMAIL) VALUES ('1002', 'MARIA', 'ARDURA MENENDEZ', 'mariaam@gmail.com');
INSERT INTO MEDICO (IDMEDICO, NOMBRE, APELLIDOS, EMAIL) VALUES ('1003', 'CRISTINA', 'GABRIEL ENJUNTO', 'enjuntoc@gmail.com');
INSERT INTO MEDICO (IDMEDICO, NOMBRE, APELLIDOS, EMAIL) VALUES ('1004', 'CHRISTIAN', 'DOMINGUEZ ALVAREZ', 'chris@gmail.com');

--VACACIONES_MEDICO (1100 - 1199)
INSERT INTO VACACIONES_MEDICO (IDVACACIONES_MEDICO, IDMEDICO, DIA_INICIO, DIA_FIN) VALUES ('1100', '1000', '2020-3-3', '2020-4-2');
INSERT INTO VACACIONES_MEDICO (IDVACACIONES_MEDICO, IDMEDICO, DIA_INICIO, DIA_FIN) VALUES ('1101', '1001', '2020-5-8', '2020-6-10');
INSERT INTO VACACIONES_MEDICO (IDVACACIONES_MEDICO, IDMEDICO, DIA_INICIO, DIA_FIN) VALUES ('1102', '1002', '2020-11-22', '2021-1-21');
INSERT INTO VACACIONES_MEDICO (IDVACACIONES_MEDICO, IDMEDICO, DIA_INICIO, DIA_FIN) VALUES ('1103', '1003', '2020-8-9', '2021-9-13');
INSERT INTO VACACIONES_MEDICO (IDVACACIONES_MEDICO, IDMEDICO, DIA_INICIO, DIA_FIN) VALUES ('1104', '1004', '2020-7-14', '2021-12-15');

--JORNADA_MEDICO (1200 - 1299)
INSERT INTO JORNADA_MEDICO (IDJORNADA_MEDICO, IDMEDICO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('1200', '1000', 'lunes, martes, miercoles, jueves, viernes','2020-05-01', '2020-11-22', '10:00', '16:00');
INSERT INTO JORNADA_MEDICO (IDJORNADA_MEDICO, IDMEDICO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('1201', '1001', 'lunes, martes, miercoles, jueves, viernes','2020-01-01', '2020-06-28', '22:00', '6:00');
INSERT INTO JORNADA_MEDICO (IDJORNADA_MEDICO, IDMEDICO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('1202', '1002', 'lunes, martes, miercoles, jueves, viernes','2020-03-04', '2020-09-22', '14:00', '18:00');
INSERT INTO JORNADA_MEDICO (IDJORNADA_MEDICO, IDMEDICO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('1203', '1003', 'lunes, martes, miercoles, jueves, viernes','2020-01-01', '2020-02-01', '19:00', '23:00');
INSERT INTO JORNADA_MEDICO (IDJORNADA_MEDICO, IDMEDICO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('1204', '1004', 'lunes, martes, miercoles, jueves, viernes','2020-07-29', '2020-10-27', '8:00', '16:00');

--ENFERMERO (2000 - 2099)
INSERT INTO ENFERMERO (IDENFERMERO, NOMBRE, APELLIDOS) VALUES ('2000', 'JAVIER', 'GARCIA LOPEZ');
INSERT INTO ENFERMERO (IDENFERMERO, NOMBRE, APELLIDOS) VALUES ('2001', 'PABLO', 'MENENDEZ GONZALEZ');
INSERT INTO ENFERMERO (IDENFERMERO, NOMBRE, APELLIDOS) VALUES ('2002', 'PAULA', 'MARTINEZ MARTINEZ');
INSERT INTO ENFERMERO (IDENFERMERO, NOMBRE, APELLIDOS) VALUES ('2003', 'DAVID', 'ARES ALVAREZ');
INSERT INTO ENFERMERO (IDENFERMERO, NOMBRE, APELLIDOS) VALUES ('2004', 'JORGE', 'RODRIGUEZ MUÑIZ');

--VACACIONES_ENFERMERO (2100 - 2199)
INSERT INTO VACACIONES_ENFERMERO (IDVACACIONES_ENFERMERO, IDENFERMERO, DIA_INICIO, DIA_FIN) VALUES ('2100', '2000', '2020-8-1', '2020-8-25');
INSERT INTO VACACIONES_ENFERMERO (IDVACACIONES_ENFERMERO, IDENFERMERO, DIA_INICIO, DIA_FIN) VALUES ('2101', '2001', '2020-11-4', '2020-8-29');
INSERT INTO VACACIONES_ENFERMERO (IDVACACIONES_ENFERMERO, IDENFERMERO, DIA_INICIO, DIA_FIN) VALUES ('2102', '2002', '2020-4-28', '2020-5-24');
INSERT INTO VACACIONES_ENFERMERO (IDVACACIONES_ENFERMERO, IDENFERMERO, DIA_INICIO, DIA_FIN) VALUES ('2103', '2003', '2020-2-4', '2020-4-13');
INSERT INTO VACACIONES_ENFERMERO (IDVACACIONES_ENFERMERO, IDENFERMERO, DIA_INICIO, DIA_FIN) VALUES ('2104', '2004', '2020-1-7', '2020-3-8');

--JORNADA_ENFERMERO (2200 - 2299)
INSERT INTO JORNADA_ENFERMERO (IDJORNADA_ENFERMERO, IDENFERMERO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('2200', '2000', 'lunes, martes, miercoles, jueves, viernes','2020-01-01', '2020-06-29', '9:00', '20:00');
INSERT INTO JORNADA_ENFERMERO (IDJORNADA_ENFERMERO, IDENFERMERO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('2201', '2001', 'lunes, martes, miercoles, jueves, viernes','2020-04-20', '2020-08-20', '7:30', '4:30');
INSERT INTO JORNADA_ENFERMERO (IDJORNADA_ENFERMERO, IDENFERMERO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('2202', '2002', 'lunes, martes, miercoles, jueves, viernes','2020-02-10', '2020-04-28', '9:00', '20:00');
INSERT INTO JORNADA_ENFERMERO (IDJORNADA_ENFERMERO, IDENFERMERO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('2203', '2003', 'lunes, martes, miercoles, jueves, viernes','2020-06-29', '2020-09-18', '11:00', '17:00');
INSERT INTO JORNADA_ENFERMERO (IDJORNADA_ENFERMERO, IDENFERMERO, DIAS, DIA_INICIO, DIA_FIN, HORA_INICIO, HORA_FIN) VALUES ('2204', '2004', 'lunes, martes, miercoles, jueves, viernes','2020-07-14', '2020-09-23', '12:00', '18:00');

--PACIENTE (3000 - 3099)
INSERT INTO PACIENTE (IDPACIENTE ,DNI, NOMBRE, APELLIDOS, EMAIL, TELEFONO) VALUES ('3000','78542660Y','ROBERTO', 'ALVAREZ DE LA FUENTE', 'roberdlf@gmail.com', '685412798');
INSERT INTO PACIENTE (IDPACIENTE ,DNI, NOMBRE, APELLIDOS, EMAIL, TELEFONO) VALUES ('3001','74512879B','LAURA', 'GONZALEZ VALDES', 'lauragv@gmail.com', '715846920');
INSERT INTO PACIENTE (IDPACIENTE ,DNI, NOMBRE, APELLIDOS, EMAIL, TELEFONO) VALUES ('3002','72210535X','MARIO', 'MARTINEZ ALONSO', 'marioalo@gmail.com', '688552317');
INSERT INTO PACIENTE (IDPACIENTE ,DNI, NOMBRE, APELLIDOS, EMAIL, TELEFONO) VALUES ('3003','65874148P','LUCAS', 'SEIZ ORTEGA', 'ortegal@gmail.com', '699447712');
INSERT INTO PACIENTE (IDPACIENTE ,DNI, NOMBRE, APELLIDOS, EMAIL, TELEFONO) VALUES ('3004','71988426B','FRANCISCO', 'MATAMOROS DIAZ', 'franmd@gmail.com', '658471524');

--HISTORIAL (3100 - 3199)
INSERT INTO HISTORIAL (IDHISTORIAL, IDPACIENTE) VALUES ('3100', '3000');
INSERT INTO HISTORIAL (IDHISTORIAL, IDPACIENTE) VALUES ('3101', '3001');
INSERT INTO HISTORIAL (IDHISTORIAL, IDPACIENTE) VALUES ('3102', '3002');
INSERT INTO HISTORIAL (IDHISTORIAL, IDPACIENTE) VALUES ('3103', '3003');
INSERT INTO HISTORIAL (IDHISTORIAL, IDPACIENTE) VALUES ('3104', '3004');

--UBICACION (5000 - 5099)
INSERT INTO UBICACION (IDUBICACION, NOMBRE) VALUES ('5000','CONSULTA 1');
INSERT INTO UBICACION (IDUBICACION, NOMBRE) VALUES ('5001','CONSULTA 2');
INSERT INTO UBICACION (IDUBICACION, NOMBRE) VALUES ('5002','CONSULTA 3');
INSERT INTO UBICACION (IDUBICACION, NOMBRE) VALUES ('5003','QUIROFANO 1');
INSERT INTO UBICACION (IDUBICACION, NOMBRE) VALUES ('5004','SALA RADIOGRAFIA 1');

--HORARIO (6000 - 6099)
INSERT INTO HORARIO (IDHORARIO, HORA_INICIO, HORA_FIN) VALUES ('6000','7:30','8:00');
INSERT INTO HORARIO (IDHORARIO, HORA_INICIO, HORA_FIN) VALUES ('6001','8:00','8:30');
INSERT INTO HORARIO (IDHORARIO, HORA_INICIO, HORA_FIN) VALUES ('6002','8:30','9:00');
INSERT INTO HORARIO (IDHORARIO, HORA_INICIO, HORA_FIN) VALUES ('6003','9:00','9:30');
INSERT INTO HORARIO (IDHORARIO, HORA_INICIO, HORA_FIN) VALUES ('6004','9:30','10:00');
INSERT INTO HORARIO (IDHORARIO, HORA_INICIO, HORA_FIN) VALUES ('6005','9:30','09:45');

--CITA (4000 - 4099)
INSERT INTO CITA (IDCITA, IDPACIENTE, IDHORARIO, IDUBICACION, FECHA, ASISTENCIA, URGENTE, INFOCONTACTO) VALUES ('4000','3000','6000', '5000', '2020-3-5', 'false', 'false', 'roberdlf@gmail.com');
INSERT INTO CITA (IDCITA, IDPACIENTE, IDHORARIO, IDUBICACION, FECHA, ASISTENCIA, URGENTE, INFOCONTACTO) VALUES ('4001','3001','6001', '5001', '2020-8-12', 'false', 'false', '715846920');
INSERT INTO CITA (IDCITA, IDPACIENTE, IDHORARIO, IDUBICACION, FECHA, ASISTENCIA, URGENTE, INFOCONTACTO) VALUES ('4002','3002','6002', '5002', '2020-2-15', 'true', 'false', '688552317');
INSERT INTO CITA (IDCITA, IDPACIENTE, IDHORARIO, IDUBICACION, FECHA, ASISTENCIA, URGENTE, INFOCONTACTO) VALUES ('4003','3003','6003', '5003', '2020-4-23', 'false', 'true', 'juanmf@gmail.com');
INSERT INTO CITA (IDCITA, IDPACIENTE, IDHORARIO, IDUBICACION, FECHA, ASISTENCIA, URGENTE, INFOCONTACTO) VALUES ('4004','3004','6004', '5004', '2020-5-17', 'true', 'true', 'Llamar al 658471524 entre las 12 y las 4');
INSERT INTO CITA (IDCITA, IDPACIENTE, IDHORARIO, IDUBICACION, FECHA, ASISTENCIA, URGENTE, INFOCONTACTO) VALUES ('4005','3004','6005', '5004', '2020-11-22', 'true', 'false', 'Llamar al 658471524 entre las 12 y las 4');

--CAUSA (4100 - 4199)
INSERT INTO CAUSA (IDCAUSA, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4100', '4000', '3000', 'Dolor intenso el brazo derecho');
INSERT INTO CAUSA (IDCAUSA, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4101', '4001', '3001', 'Edad avanzada');
INSERT INTO CAUSA (IDCAUSA, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4102', '4002', '3002', 'Dolor de cabeza');
INSERT INTO CAUSA (IDCAUSA, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4103', '4003', '3003', 'Tos fuerte');
INSERT INTO CAUSA (IDCAUSA, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4104', '4004', '3004', 'Fiebre y dificultad para respirar');

--PRESCRIPCION (4200 - 4299)
INSERT INTO PRESCRIPCION (IDPRESCRIPCION, INSTRUCCION, HORA_ASIGNACION, DIA_ASIGNACION, ES_MEDICAMENTO) VALUES ('4200', 'Pastillas calmantes para el dolor', '12:45', '2020-3-5', 'true');
INSERT INTO PRESCRIPCION (IDPRESCRIPCION, INSTRUCCION, HORA_ASIGNACION, DIA_ASIGNACION, ES_MEDICAMENTO) VALUES ('4201', 'Paracetamol', '10:55', '2020-8-12', 'true');
INSERT INTO PRESCRIPCION (IDPRESCRIPCION, INSTRUCCION, HORA_ASIGNACION, DIA_ASIGNACION, ES_MEDICAMENTO) VALUES ('4202', 'Ibuprofeno', '16:20', '2020-2-15', 'true');
INSERT INTO PRESCRIPCION (IDPRESCRIPCION, INSTRUCCION, HORA_ASIGNACION, DIA_ASIGNACION, ES_MEDICAMENTO) VALUES ('4203', 'Etambutol', '11:15', '2020-4-23', 'true');
INSERT INTO PRESCRIPCION (IDPRESCRIPCION, INSTRUCCION, HORA_ASIGNACION, DIA_ASIGNACION, ES_MEDICAMENTO) VALUES ('4204', 'Analgésicos', '8:45', '2020-9-22', 'true');
INSERT INTO PRESCRIPCION (IDPRESCRIPCION, INSTRUCCION, HORA_ASIGNACION, DIA_ASIGNACION, ES_MEDICAMENTO) VALUES ('4205', 'Beber agua', '9:45', '2020-11-22', 'false');

--MEDICAMENTO (4300 - 4399)
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, IDPRESCRIPCION, NOMBRE, CANTIDAD, INTERVALO, DURACION, ANOTACION) VALUES ('4300', '4200', 'Pastillas calmantes para el dolor', '1', 'Cada 8 horas', '10 dias', 'No abusar del medicamento');
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, IDPRESCRIPCION, NOMBRE, CANTIDAD, INTERVALO, DURACION, ANOTACION) VALUES ('4301', '4201', 'Paracetamol', '1', 'Cada 12 horas', '30 dias', 'No son necesarias mas observaciones');
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, IDPRESCRIPCION, NOMBRE, CANTIDAD, INTERVALO, DURACION, ANOTACION) VALUES ('4302', '4202', 'Ibuprofeno', '1', 'Cada 8 horas', '5 dias', 'Seguir los intervalos');
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, IDPRESCRIPCION, NOMBRE, CANTIDAD, INTERVALO, DURACION, ANOTACION) VALUES ('4303', '4203', 'Etambutol', '1', 'Cada 24 horas', '6 meses', 'No son necesarias mas observaciones');
INSERT INTO MEDICAMENTO (IDMEDICAMENTO, IDPRESCRIPCION, NOMBRE, CANTIDAD, INTERVALO, DURACION, ANOTACION) VALUES ('4304', '4204', 'Analgésicos', '1', 'Cada 24 horas', '1 mes', 'No son necesarias mas observaciones');

--DIAGNOSTICO (4400 - 4499)
INSERT INTO DIAGNOSTICO (IDDIAGNOSTICO, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4400', '4000', '3000', 'Fractura de cúbito');
INSERT INTO DIAGNOSTICO (IDDIAGNOSTICO, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4401', '4001', '3001', 'Artrosis');
INSERT INTO DIAGNOSTICO (IDDIAGNOSTICO, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4402', '4002', '3002', 'Migrañas');
INSERT INTO DIAGNOSTICO (IDDIAGNOSTICO, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4403', '4003', '3003', 'Tuberculosis');
INSERT INTO DIAGNOSTICO (IDDIAGNOSTICO, IDCITA, IDPACIENTE, DESCRIPCION) VALUES ('4404', '4004', '3004', 'Neumonia');

--MEDICO_CITAS (4500 - 4599)
INSERT INTO MEDICO_CITAS (IDCITA, IDMEDICO) VALUES ('4000', '1000');
INSERT INTO MEDICO_CITAS (IDCITA, IDMEDICO) VALUES ('4001', '1001');
INSERT INTO MEDICO_CITAS (IDCITA, IDMEDICO) VALUES ('4002', '1002');
INSERT INTO MEDICO_CITAS (IDCITA, IDMEDICO) VALUES ('4003', '1003');
INSERT INTO MEDICO_CITAS (IDCITA, IDMEDICO) VALUES ('4004', '1004');

--PRESCRIPCION_CITAS_PACIENTE (4600 - 4699)
INSERT INTO PRESCRIPCION_CITAS_PACIENTE (IDPRESCRIPCION ,IDCITA, IDPACIENTE) VALUES ('4200','4000', '3000');
INSERT INTO PRESCRIPCION_CITAS_PACIENTE (IDPRESCRIPCION ,IDCITA, IDPACIENTE) VALUES ('4201','4001', '3001');
INSERT INTO PRESCRIPCION_CITAS_PACIENTE (IDPRESCRIPCION ,IDCITA, IDPACIENTE) VALUES ('4202' ,'4002', '3002');
INSERT INTO PRESCRIPCION_CITAS_PACIENTE (IDPRESCRIPCION ,IDCITA, IDPACIENTE) VALUES ('4203' ,'4003', '3003');
INSERT INTO PRESCRIPCION_CITAS_PACIENTE (IDPRESCRIPCION ,IDCITA, IDPACIENTE) VALUES ('4204' ,'4004', '3004');
INSERT INTO PRESCRIPCION_CITAS_PACIENTE (IDPRESCRIPCION ,IDCITA, IDPACIENTE) VALUES ('4205' ,'4005', '3004');





