CREATE TABLE tb_missions (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(255),
                             difficulty VARCHAR(50)
);


CREATE TABLE tb_ninja_registration (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255),
                                       email VARCHAR(255) UNIQUE,
                                       age INT,
                                       missions_id BIGINT,

                                       CONSTRAINT fk_ninja_mission FOREIGN KEY (missions_id) REFERENCES tb_missions(id)
);