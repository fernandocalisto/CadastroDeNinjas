--V2: Migrations para adicionar a coluna de RANK na tabela de cadastros

ALTER TABLE tb_ninja_registration
ADD COLUMN ran VARCHAR(255);