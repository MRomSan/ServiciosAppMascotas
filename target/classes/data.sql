INSERT IGNORE INTO roles(id, nombre) VALUES(1, 'ROLE_USER');
INSERT IGNORE INTO roles(id, nombre) VALUES(2, 'ROLE_ADMIN');

INSERT IGNORE INTO usuarios(id_usuario, nombre, apellidos, telefono, username, password, alta)
    VALUES(1, 'admin', 'admin', '000000000', 'admin', '$2a$10$TLiRZZykCLZSPAkd/UwisesIRSpvxBqsH9sWSUcvumTSRKlrD/joy', 1);

INSERT IGNORE INTO usuario_roles(id_usuario, id_rol) VALUES (1, 2);