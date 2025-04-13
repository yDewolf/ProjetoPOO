# Página de documentação sobre utilidades

## Classes Abstratas:
- [BaseMenu](#basemenu);

## Classes:
- [UserInput](#userinput);
- [Menu](#menu);

## UserInput
Classe usada para facilitar entradas de usuário no console usando a classe Scanner do ``java.util``

### Métodos:
- ``nextInt(int min, int max, String invalid_input_message)``<br>
**Equivalente ao ``Scanner.nextInt``**<br>
Retorna um número inteiro ``n`` em que ``[n > min && n < max]``<br>
Checa se valores inválidos são inseridos e automaticamente pede para o usuário inserir outro valor<br>
Escreve o conteúdo de ``invalid_input_message`` toda vez que um valor inválido é inserido.

- ``nextString(int min_length, int max_length, String invalid_input_message, String[] invalid_characteres)``<br>
**Equivalente ao ``Scanner.nextLine``** *Não confundir com Scanner.next<br>
Retorna a linha mais recente digitada pelo usuário em que ``linha.length() > min && linha.length() < max_length``<br>
Verifica se a linha digitada pelo usuário contém algum caractere inválido<br>
Escreve o conteúdo de ``invalid_input_message`` toda vez que um valor inválido é enviado

## Menu
**É derivada de BaseMenu**<br>
É usada para instanciar a classe abstrata BaseMenu

### Métodos:
- ``selectOption(String[] options, boolean first_goest_last, String title)``<br>
Define automaticamente invalid_input_message para "Your input is invalid"<br>
- ``getInput(int min_length, int max_length, String title, String invalid_input_message)``<br>
Define automaticamente invalid_characters para um array vazio

## BaseMenu
**Classe abstrata para menus simples**<br>
Usada como uma continuação da classe UserInput.<br>
Basicamente gera menus um pouco mais visuais mas que ainda mantém a sua funcionalidade implementada em UserInput

### Métodos:
- ``selectOption(String[] options, boolean first_goes_last, String title, String invalid_input_message)``<br>
Escreve no console o conteúdo da variável ```title```<br>
Embaixo do título, escreve cada opção (```options[idx]```) no formato ```"[" + idx + "]-" + options[idx]```<br>
Usa ```UserInput.nextInt``` para receber um valor entre ```0``` e ```options.length```

- ``getInput(int min_length, int max_length, String title, String invalid_input_message, String[] invalid_characters)``<br>
Escreve no console o conteúdo da variável ```title```<br>
Embaixo do título, escreve cada caractere inválido<br>
Usa ```UserInput.nextString``` para receber uma linha digitada pelo usuário

- ``stringifyOptions(String[] options, boolean first_goes_last)``<br>
Retorna uma String com as opções no formato ```"[" + idx + "]-" + options[idx]```
