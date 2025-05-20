# Sistema de Gerenciamento de Estacionamento

Este projeto é um sistema simples de gerenciamento de estacionamento, desenvolvido em Java, utilizando conceitos de Programação Orientada a Objetos (POO).

## Estrutura do Projeto
- `src/Controller/`: Contém as classes responsáveis pelo controle do sistema e menus de interação.
- `src/models/`: Contém as classes que representam os modelos do sistema, como Veículo, Estacionamento e Vagas.
- `src/enums/`: Contém os tipos enumerados, como Tipo de veículo e Marca.
- `src/BD/`: Simula um banco de dados em memória para veículos e estacionamento.

## Funcionalidades
- **Cadastro e busca de veículos**: Permite adicionar veículos ao sistema e pesquisar por placa.
- **Gestão de vagas**: Permite cadastrar, excluir e listar vagas do estacionamento.
- **Alteração de tarifas**: Permite modificar dinamicamente as tarifas de CARRO, MOTO e UNITARIO pelo menu de gestão.
- **Menus interativos**: O sistema possui menus para atendimento e gestão, acessíveis via terminal.

## Observações
- O sistema utiliza enums para tipos de veículos e marcas, facilitando a manutençã.
- As tarifas podem ser alteradas em tempo de execução pelo menu de gestão.

## Exemplo de Uso
- Pesquisar veículo por placa
- Alterar tarifa de um tipo de veículo
- Listar vagas do estacionamento

---
