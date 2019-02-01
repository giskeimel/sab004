insert into direccion (numero,calle,piso,departamento) values(1900,'misiones',0,null);
insert into direccion (numero,calle,piso,departamento) values(500,'alem',0,null);
INSERT INTO direccion (numero, calle, piso, departamento) values (2100, 'misiones', 3, '...');
INSERT INTO direccion (numero, calle, piso, departamento) values (2340, 'formosa', 2, '...');
INSERT INTO direccion (numero, calle, piso, departamento) values (345, 'Doering', 1, '...');
INSERT INTO direccion (numero, calle, piso, departamento) values (442, '11 de Septiembre', 2, '...');
INSERT INTO direccion (numero, calle, piso, departamento) values (532, 'Grl.Paz', 1, '...');

insert into lugar(nombre,id_direccion) values ('CIQ',1);
insert into lugar(nombre,id_direccion) values('hospital',2);

INSERT INTO especialidad (nombre) VALUES ('De Familia');
INSERT INTO especialidad (nombre) VALUES ('Traumatologo');
INSERT INTO especialidad (nombre) VALUES ('Ginecologia');

insert into lugar_nn_especialidad(id_lugar,id_especialidad) values(1,2);
insert into lugar_nn_especialidad(id_lugar,id_especialidad) values(1,3);
insert into lugar_nn_especialidad(id_lugar,id_especialidad) values(1,1);
insert into lugar_nn_especialidad(id_lugar,id_especialidad) values(2,3);
insert into lugar_nn_especialidad(id_lugar,id_especialidad) values(2,1);
insert into lugar_nn_especialidad(id_lugar,id_especialidad) values(2,2);

insert into turno(fecha,libre,id_lugar,id_especialidad,id_paciente)values('2019-01-28 10:15:00',0,1,2,null);
insert into turno(fecha,libre,id_lugar,id_especialidad,id_paciente)values('2019-01-28 10:30:00',0,1,2,null);
insert into turno(fecha,libre,id_lugar,id_especialidad,id_paciente)values('2019-01-28 10:45:00',0,2,2,null);
insert into turno(fecha,libre,id_lugar,id_especialidad,id_paciente)values('2019-01-28 11:00:00',0,2,2,null);

insert into cuenta(usuario,contraseña)values('Pablo','Pablo');
insert into cuenta(usuario,contraseña)values('Manuel','Manuel');
insert into cuenta(usuario,contraseña)values('Rodrigo','Rodrigo');
insert into cuenta(usuario,contraseña)values('Fransisco','Francisco');


INSERT INTO paciente(historia_clinica, nombre, apellido, email, telefono, id_Lugar, id_direccion, id_cuenta, observaciones) 
Values (001,'Pablo', 'Andrade', 'pablo123_@hotmail.com',154999178,1, 3 ,1, 'No tiene salvacion');
INSERT INTO paciente(historia_clinica, nombre, apellido, email, telefono, id_lugar, id_direccion, id_cuenta, observaciones) 
Values (002,'Manuel', 'Saponte', 'Naru32_@hotmail.com',154466578, 1, 4 , 2, 'Le cuesta respirar');
INSERT INTO paciente(historia_clinica, nombre, apellido, email, telefono, id_lugar, id_direccion, id_cuenta,observaciones) 
Values (003,'Rodrigo', 'Perez', 'rodri_@gmail.com',154494128, 2, 5 ,3, '...');
INSERT INTO paciente(historia_clinica, nombre, apellido, email, telefono, id_lugar, id_direccion,id_cuenta, observaciones) 
Values (004,'Francisco', 'Castillo', 'curva_@hotmail.com',154499178,2,6,4, '...');

insert into cuenta(usuario,contraseña)values('Mauricio','Mauricio');
insert into cuenta(usuario,contraseña)values('andrea','andrea');
insert into cuenta(usuario,contraseña)values('catalina','catalina');
insert into cuenta(usuario,contraseña)values('ortencia','ortencia');



INSERT INTO Empleado (legajo, nombre, apellido, email, id_cuenta, id_lugar) 
values (120, 'Mauricio', 'Gonzalez', 'mauro@hotmail.com', 5, 1);
INSERT INTO Empleado (legajo, nombre, apellido, email, id_cuenta,  id_lugar) 
values (121, 'Andrea', 'Ameghino', 'Mari@gmail.com', 6, 2);
INSERT INTO Empleado (legajo, nombre, apellido, email, id_cuenta,  id_lugar) 
values (122, 'Catalina', 'Marcoveccio', 'Cata@gmail.com', 7, 2);
INSERT INTO Empleado (legajo, nombre, apellido, email, id_cuenta,  id_lugar)
values (123, 'Ortencia', 'Ramirez', 'flor234@hotmail.com',8, 1); 
