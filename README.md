# Cadastro de Imposto - Sistema de Cálculo de Impostos

## 📋 Descrição

Sistema Java desenvolvido para calcular e gerenciar diferentes tipos de impostos e contribuições incidentes sobre operações comerciais. O projeto implementa uma arquitetura orientada a objetos com uso de interfaces e polimorfismo, permitindo fácil extensão para novos tipos de impostos.

---

## 🎯 Funcionalidades

- ✅ Cadastro de impostos **PIS (Programa de Integração Social)**
- ✅ Cadastro de impostos **IPI (Imposto sobre Produtos Industrializados)**
- ✅ Cálculo automático de impostos com base em parâmetros específicos
- ✅ Listagem de impostos cadastrados com valores calculados
- ✅ Resumo final com total de impostos a pagar
- ✅ Interface de linha de comando intuitiva
- ✅ Validação de entrada de dados
- ✅ Formatação monetária de valores (2 casas decimais)

---

## 🏗️ Arquitetura do Projeto

### Estrutura de Diretórios

```
src/
├── App.java                          # Programa principal com menu interativo
├── impostos/
│   ├── interfase/
│   │   └── Imposto.java             # Interface base para todos os impostos
│   └── tipos/
│       ├── ImpostoPis.java          # Implementação do PIS
│       └── ImpostoIpi.java          # Implementação do IPI
└── pagamentos/
    └── Pagamentos.java              # Classe para gerenciar lista de impostos
```

### 📐 Diagrama de Classes

```
┌─────────────────────┐
│     Imposto         │ (Interface)
├─────────────────────┤
│ + calcular()        │
│ + getDescricao()    │
└──────────┬──────────┘
           │ implements
           │
    ┌──────┴──────┐
    │             │
┌───────────┐  ┌──────────┐
│ImpostoPis │  │ImpostoIpi│
└───────────┘  └──────────┘

┌──────────────────────┐
│    Pagamentos        │
├──────────────────────┤
│ - nomeEmpresa        │
│ - impostos: List     │
├──────────────────────┤
│ + adicionarImposto() │
│ + getImpostos()      │
│ + getNomeEmpresa()   │
└──────────────────────┘
```

---

## 📝 Descrição das Classes

### **1. Interface `Imposto`**
- **Localização:** `src/impostos/interfase/Imposto.java`
- **Responsabilidade:** Define o contrato que todos os impostos devem cumprir
- **Métodos:**
  - `double calcular()` - Calcula o valor do imposto
  - `String getDescricao()` - Retorna descrição do imposto

### **2. Classe `ImpostoPis`**
- **Localização:** `src/impostos/tipos/ImpostoPis.java`
- **Responsabilidade:** Implementar o cálculo do PIS
- **Atributos:**
  - `descricao: String` - Descrição do imposto
  - `debito: double` - Valor total de débito
  - `credito: double` - Valor total de crédito
- **Fórmula de Cálculo:** `(débito - crédito) × 1,65%`
- **Exemplo:**
  ```
  Débito: R$ 30.000,00
  Crédito: R$ 16.000,00
  Base: 30.000 - 16.000 = R$ 14.000,00
  PIS = 14.000 × 1,65% = R$ 231,00
  ```

### **3. Classe `ImpostoIpi`**
- **Localização:** `src/impostos/tipos/ImpostoIpi.java`
- **Responsabilidade:** Implementar o cálculo do IPI
- **Atributos:**
  - `descricao: String` - Descrição do imposto
  - `produto: double` - Valor do produto
  - `frete: double` - Valor do frete
  - `seguro: double` - Valor do seguro
  - `outrasDespesas: double` - Outras despesas
  - `aliquota: double` - Percentual da alíquota (%)
- **Fórmula de Cálculo:** `(produto + frete + seguro + outrasDespesas) × alíquota%`
- **Exemplo:**
  ```
  Produto: R$ 90,00
  Frete: R$ 10,00
  Seguro: R$ 5,00
  Outras Despesas: R$ 5,00
  Base: 90 + 10 + 5 + 5 = R$ 110,00
  Alíquota: 5%
  IPI = 110 × 5% = R$ 5,50
  ```

### **4. Classe `Pagamentos`**
- **Localização:** `src/pagamentos/Pagamentos.java`
- **Responsabilidade:** Gerenciar lista de impostos e dados da empresa
- **Atributos:**
  - `nomeEmpresa: String` - Nome da empresa
  - `impostos: ArrayList<Imposto>` - Lista dinâmica de impostos
- **Métodos:**
  - `adicionarImposto(Imposto)` - Adiciona novo imposto à lista
  - `getImpostos()` - Retorna lista de impostos
  - `getNomeEmpresa()` - Retorna nome da empresa

### **5. Classe `App`**
- **Localização:** `src/App.java`
- **Responsabilidade:** Interface com usuário e coordenação do programa
- **Fluxo:**
  1. Solicita nome da empresa
  2. Exibe menu de opções
  3. Permite cadastro de impostos (IPI e PIS)
  4. Exibe resumo final ao encerrar

---

## 🚀 Como Executar

### Pré-requisitos
- Java 8 ou superior instalado
- IDE (NetBeans, Eclipse, IntelliJ) ou compilador `javac`

### Compilação
```bash
# Navegue até o diretório do projeto
cd src

# Compile todos os arquivos Java
javac -d ../bin *.java impostos/interfase/*.java impostos/tipos/*.java pagamentos/*.java

# Ou, se estiver usando uma IDE, compile diretamente
```

### Execução
```bash
# Navegue até o diretório bin
cd ../bin

# Execute o programa
java App
```

---

## 📖 Guia de Uso

### Menu Principal

```
=== Cadastro de Impostos ===
Digite 'pare' para encerrar o cadastro de impostos.

Menu de Impostos
1. Adicionar Imposto IPI
2. Adicionar Imposto PIS
Escolha uma opcao (ou digite 'pare' para encerrar): 
```

### Adicionando Imposto IPI

```
Adicionar Imposto IPI
Digite a descricao do imposto: IPI - Produto A
Digite o valor do produto: 90
Digite o valor do frete: 10
Digite o valor do seguro: 5
Digite o valor de outras despesas: 5
Digite a aliquota do imposto (%): 5
Imposto IPI adicionado com sucesso!
```

### Adicionando Imposto PIS

```
Adicionar Imposto PIS
Digite a descricao do imposto: PIS - Operação Normal
Digite o valor do debito: 30000
Digite o valor do credito: 16000
Imposto PIS adicionado com sucesso!
```

### Encerramento e Resumo

```
Empresa: Minha Empresa LTDA
=== Impostos Calculados ===
-------------------------------
Descricao: IPI - Produto A
Valor do imposto: R$ 5.5
-------------------------------
Descricao: PIS - Operação Normal
Valor do imposto: R$ 231.0
-------------------------------
Total de impostos: R$ 236.5

Encerrando a aplicacao
```

---

## 🔧 Histórico de Commits

O projeto foi desenvolvido incrementalmente com commits bem definidos:

### Fase 1: Setup Inicial (Commits 1-2)
- Inicializar Scanner e ler nome da empresa
- Adicionar menu principal e loop do programa

### Fase 2: Implementação de Cases (Commits 3-5)
- Implementar case 1 - Adicionar Imposto IPI
- Implementar case 2 - Adicionar Imposto PIS
- Implementar case 3 - Listar Impostos e case default

### Fase 3: Refatoração e Melhorias (Commits 6-10)
- Refatorar loop principal para usar "pare" como encerramento
- Adicionar resumo final com total de impostos
- Consumir corretamente quebra de linha do Scanner
- Implementar validação de entrada
- Melhorar formatação com separadores visuais

Para ver o histórico completo:
```bash
git log --oneline
```

---

## ✨ Encapsulamento e Boas Práticas

### Encapsulamento
- ✅ Todos os atributos são privados
- ✅ Acesso controlado via getters públicos
- ✅ Modificação via construtores e métodos apropriados

### Construtores
- ✅ `Pagamentos(String nomeEmpresa)` - Inicializa empresa e lista vazia
- ✅ `ImpostoPis(String, double, double)` - Inicializa PIS com parâmetros
- ✅ `ImpostoIpi(String, double, double, double, double, double)` - Inicializa IPI

### Polimorfismo
- ✅ Interface `Imposto` permite adicionar novos impostos sem modificar código existente
- ✅ Cada classe concreta implementa seu próprio `calcular()`

---

## 🎓 Aprendizados Principais

1. **Interfaces e Polimorfismo** - Uso de contrato comum para diferentes tipos de impostos
2. **Encapsulamento** - Proteção de dados com atributos privados
3. **Collections** - Uso de `ArrayList` para gerenciar múltiplos impostos
4. **Tratamento de Entrada** - Validação e consumo correto do buffer do Scanner
5. **Separação de Responsabilidades** - Classes especializadas em tarefas específicas

---

## 🔮 Extensibilidade Futura

O sistema foi projetado para fácil extensão:

### Adicionar Novo Imposto
```java
// 1. Criar nova classe que implementa Imposto
public class ImpostoICMS implements Imposto {
    // Implementar calcular() e getDescricao()
}

// 2. Adicionar novo case no switch de App.java
case 3:
    // Lógica para adicionar ICMS
    pagamentos.adicionarImposto(new ImpostoICMS(...));
    break;
```

---

## 📊 Conformidade com Requisitos

| Requisito | Status | Detalhes |
|-----------|--------|----------|
| Hierarquia de classes/interfaces | ✅ | Interface `Imposto` e 2 implementações |
| Cálculo PIS correto | ✅ | Fórmula: (débito - crédito) × 1,65% |
| Cálculo IPI correto | ✅ | Fórmula: (base) × alíquota |
| Classe Pagamentos | ✅ | Gerencia empresa e lista de impostos |
| Encapsulamento | ✅ | Atributos privados com getters |
| Construtores | ✅ | Inicialização completa de objetos |
| Menu interativo | ✅ | Permite cadastro de múltiplos impostos |
| Critério "pare" | ✅ | Encerramento ao digitar "pare" |
| Resumo final | ✅ | Exibe empresa, impostos e total |
| Formatação monetária | ✅ | Valores em R$ com 2 casas decimais |

---

## 📧 Informações do Projeto

- **Disciplina:** UC6_01 - Desenvolvimento Java
- **Tipo:** Atividade Prática - Sistema de Impostos
- **Linguagem:** Java 8+
- **Padrão:** Programação Orientada a Objetos (POO)
- **Data:** 28 de novembro de 2025

---

## 📝 Licença

Este projeto é fornecido como material educacional.

---

**Desenvolvido com ❤️ em Java**
