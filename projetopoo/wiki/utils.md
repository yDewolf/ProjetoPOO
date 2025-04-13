# Página de documentação sobre utilidades

## Classes Abstratas:
- BaseMenu

## Classes:
- UserInput;
- Menu;

## UserInput
Classe usada para facilitar entradas de usuário no console usando a classe Scanner do ``java.util``

### Métodos:
- ``nextInt(int min, int max, String invalid_input_message)``
**Equivalente ao ``Scanner.nextInt``**
Retorna um número inteiro ``n`` em que ``[n > min && n < max]``
Checa se valores inválidos são inseridos e automaticamente pede para o usuário inserir outro valor
Escreve o conteúdo de ``invalid_input_message`` toda vez que um valor inválido é inserido.

- ``nextString(int min_length, int max_length, String invalid_input_message, String[] invalid_characteres)``
**Equivalente ao ``Scanner.nextLine``** *Não confundir com Scanner.next
Retorna a linha mais recente digitada pelo usuário em que ``linha.length() > min && linha.length() < max_length``
Verifica se a linha digitada pelo usuário contém algum caractere inválido
Escreve o conteúdo de ``invalid_input_message`` toda vez que um valor inválido é enviado

## Menu
**É derivada de BaseMenu**
É usada para instanciar a classe abstrata BaseMenu

### Métodos:
- ``selectOption(String[] options, boolean first_goest_last, String title)``
Define automaticamente invalid_input_message para "Your input is invalid"
- ``getInput(int min_length, int max_length, String title, String invalid_input_message)``
Define automaticamente invalid_characters para um array vazio

## BaseMenu
**Classe abstrata para menus simples**
Usada como uma continuação da classe UserInput.
Basicamente gera menus um pouco mais visuais mas que ainda mantém a sua funcionalidade implementada em UserInput

### Métodos:
- ``selectOption(String[] options, boolean first_goes_last, String title, String invalid_input_message)``
Escreve no console o conteúdo da variável ```title```
Embaixo do título, escreve cada opção (```options[idx]```) no formato ```"[" + idx + "]-" + options[idx]```
Usa ```UserInput.nextInt``` para receber um valor entre ```0``` e ```options.length```

- ``getInput(int min_length, int max_length, String title, String invalid_input_message, String[] invalid_characters)``
Escreve no console o conteúdo da variável ```title```
Embaixo do título, escreve cada caractere inválido
Usa ```UserInput.nextString``` para receber uma linha digitada pelo usuário

- ``stringifyOptions(String[] options, boolean first_goes_last)``
Retorna uma String com as opções no formato ```"[" + idx + "]-" + options[idx]```