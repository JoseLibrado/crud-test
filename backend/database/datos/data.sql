insert into employees(first_name,last_name,position_rol) values('Librado','Soto','developer');
insert into employees(first_name,last_name,position_rol) values('Jose','Soto','Tester');

insert into inventory(sku,product_name,total_amount) values('MTOHONDA3554235','Motocicleta honda ',30);
insert into inventory(sku,product_name,total_amount) values('LICMAVE44392989845','Licuadora ninja',100);
insert into inventory(sku,product_name,total_amount) values('LAVAWIRP93858503','Lavadora wifi integrado',50);
insert into inventory(sku,product_name,total_amount) values('STUFCOBLENS29471084','Estufa luxury cristal',100);

insert into policies(sku, amount, policy_date, id_employee,status_policy) values('MTOHONDA3554235',1,CURRENT_DATE,1,'PEN');
insert into policies(sku, amount, policy_date, id_employee,status_policy) values('LICMAVE44392989845',1,CURRENT_DATE,1,'PEN');
insert into policies(sku, amount, policy_date, id_employee,status_policy) values('LAVAWIRP93858503',1,CURRENT_DATE,1,'REV');
insert into policies(sku, amount, policy_date, id_employee,status_policy) values('STUFCOBLENS29471084',1,CURRENT_DATE,2,'CAN');


INSERT INTO cat_status_policy(clave, description) VALUES('PEN','Pendiente');
INSERT INTO cat_status_policy(clave, description) VALUES('REV','Revision');
INSERT INTO cat_status_policy(clave, description) VALUES('FIN','Finalizada');
INSERT INTO cat_status_policy(clave, description) VALUES('CAN','Cancelada');