# Parking-control
Estudo java  Spring boot
referente ao video : https://www.youtube.com/watch?v=LXRU-Z36GEU
# 🚗 Parking Control API

API RESTful desenvolvida com **Java e Spring Boot** para o controle de vagas de estacionamento de um condomínio. A API permite realizar todas as operações CRUD (Criar, Ler, Atualizar e Deletar) para as vagas, além de possuir validações para garantir a integridade dos dados.

---

## ✨ Funcionalidades Principais

* **Cadastro de Vagas (POST):** Permite registrar uma nova vaga de estacionamento.
* **Listagem de Vagas (GET):** Retorna uma lista paginada de todas as vagas cadastradas.
* **Consulta por ID (GET):** Busca e exibe uma vaga específica pelo seu identificador único (UUID).
* **Atualização de Vagas (PUT):** Permite modificar os dados de uma vaga já existente.
* **Exclusão de Vagas (DELETE):** Remove o registro de uma vaga do sistema.
* **Regras de Negócio:** O sistema impede o cadastro de dados duplicados, validando:
    * Placa do carro.
    * Número da vaga de estacionamento.
    * Vaga já registrada para um apartamento/bloco.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** **Java 11+**
* **Framework:** **Spring Boot**
    * **Spring Web:** Para a criação dos endpoints REST.
    * **Spring Data JPA:** Para a persistência e comunicação com o banco de dados.
    * **Spring Validation:** Para a validação dos dados de entrada.
* **Gerenciador de Dependências:** **Maven** ou **Gradle**.
* **Banco de Dados:** [**Insira aqui o banco de dados, ex: PostgreSQL, H2, MySQL**]

---

## Endpoints da API

A URL base para todos os endpoints é `/parking-spot`.

### 1. Cadastrar Vaga

* **Método:** `POST`
* **URL:** `/parking-spot`
* **Corpo da Requisição (JSON):**
    ```json
    {
      "parkingSpotNumber": "101B",
      "licencePlateCar": "BRA2E19",
      "brandCar": "Chevrolet",
      "modelCar": "Onix",
      "colorCar": "Preto",
      "responsibleName": "Fulano de Tal",
      "apartment": "21",
      "block": "A"
    }
    ```
* **Respostas:**
    * `201 CREATED`: Se a vaga for criada com sucesso.
    * `409 CONFLICT`: Se a placa, a vaga ou o apartamento/bloco já estiverem em uso.

---

### 2. Listar Todas as Vagas

* **Método:** `GET`
* **URL:** `/parking-spot`
* **Parâmetros de Query (Opcional para paginação):**
    * `page`: número da página (padrão: `0`).
    * `size`: quantidade de itens por página (padrão: `10`).
    * `sort`: campo para ordenação (padrão: `id,ASC`).
* **Resposta:**
    * `200 OK`: Retorna uma lista com as vagas.

---

### 3. Obter Vaga por ID

* **Método:** `GET`
* **URL:** `/parking-spot/{id}`
* **Respostas:**
    * `200 OK`: Se a vaga for encontrada, retorna seus dados.
    * `404 NOT FOUND`: Se não existir vaga com o ID informado.

---

### 4. Atualizar Vaga

* **Método:** `PUT`
* **URL:** `/parking-spot/push/{id}`
* **Corpo da Requisição (JSON):** Contém os campos que você deseja atualizar.
* **Respostas:**
    * `200 OK`: Se a vaga for atualizada com sucesso.
    * `404 NOT FOUND`: Se não existir vaga com o ID informado.

---

### 5. Deletar Vaga

* **Método:** `DELETE`
* **URL:** `/parking-spot/{id}`
* **Respostas:**
    * `200 OK`: Se a vaga for deletada com sucesso.
    * `404 NOT FOUND`: Se não existir vaga com o ID informado.
