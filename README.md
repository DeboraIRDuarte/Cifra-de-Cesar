# Cifra de César – Java

Este projeto implementa a Cifra de César em Java, com funcionalidades de encriptação, análise de frequência de letras e criptoanálise por força bruta.

## ✨ Funcionalidades

- Encriptação com qualquer valor de deslocamento.
- Análise de frequência das letras da mensagem cifrada.
- Estimativa do deslocamento com base na letra mais frequente (assumindo 'E' como mais comum em português).
- Força bruta para descobrir o deslocamento real.
- Classe de testes automatizados com JUnit 5.

## 🗂 Estrutura

```
src/
├── main/
│   └── java/
│       └── com/example/cifradecesar/
│           └── CifraDeCesar.java
└── test/
    └── java/
        └── com/example/cifradecesar/
            └── TesteCifraDeCesar.java
```

## ▶️ Como executar

### Compilar e executar o programa principal:

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.example.cifradecesar.CifraDeCesar"
```

### Rodar os testes com JUnit:

```bash
mvn test
```

## 🧪 Exemplo de uso

Ao rodar o programa, ele solicitará:

```
Digite a mensagem original:
```

E em seguida:

```
Digite o deslocamento (chave):
```

A saída exibirá:

- Mensagem cifrada
- Frequência de letras
- Deslocamento estimado
- Mensagem decifrada por estimativa
- Resultado por força bruta

## 🧱 Requisitos

- Java 17+
- Maven
- JUnit 5 (já incluído no `pom.xml`)

## 📄 Licença

Uso acadêmico e educacional. Livre para adaptação com créditos.
