-- Tabela de Usuários para Autenticação Security/JWT
INSERT INTO tb_usuario ( username, password, role)
VALUES ( 'Gabrieli', '$2a$12$UTc/QPOuWNLQVM6P7DaA8eRLl3cOgWUEXXbHNNYioEqd1fyUfmBhC', 'ADMIN'),
       ( 'Diego', '$2a$12$UTc/QPOuWNLQVM6P7DaA8eRLl3cOgWUEXXbHNNYioEqd1fyUfmBhC', 'USER');

-- Tabela de Motoristas
INSERT INTO tb_motorista ( nome, cnh)
VALUES ( 'Entregador', '00273297870');

-- Tabela de Entregas (Relacionamento com Motorista)
INSERT INTO tb_entrega (descricao, status, motorista_id)
VALUES  ('Entrega muito boa e rápida', 'ENTREGUE', '1');