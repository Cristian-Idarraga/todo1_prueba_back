INSERT INTO rol(cdrol, nombre, descripcion, estado, fecha_creacion)VALUES(1, 'admin', 'Administrador', 'A', NOW());
INSERT INTO rol(cdrol, nombre, descripcion, estado, fecha_creacion)VALUES(2, 'user', 'Usuario', 'A', NOW());

INSERT INTO maestro(cdmaestro, codigo, descripcion, estado, fecha_creacion)VALUES(1, 'TD', 'Tipo documento', 'A', NOW());
INSERT INTO maestro(cdmaestro, codigo, descripcion, estado, fecha_creacion)VALUES(2, 'CAT', 'Categoria', 'A', NOW());

INSERT INTO datomaestro(cddato, cdmaestro, codigo, descripcion, estado, fecha_creacion)VALUES(1, 1, 'CC', 'Cedula de ciudadania', 'A', NOW());
INSERT INTO datomaestro(cddato, cdmaestro, codigo, descripcion, estado, fecha_creacion)VALUES(2, 2, 'MV', 'Marvel', 'A', NOW());
INSERT INTO datomaestro(cddato, cdmaestro, codigo, descripcion, estado, fecha_creacion)VALUES(3, 2, 'DC', 'DC Comic', 'A', NOW());



