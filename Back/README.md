Use cases 

ActivePlayerNextStage: En este caso de uso se evaluaran los jugadores que van a pasar a una siguiente etapa, los cuales tienen que contar con el saldo suficiente para apostar y además debe haber acertado su adivinanza en la etapa. En este caso de uso se debe tarer una lista de los player Ids para hacer la verificacion de qeuines pueden avanzara  a la siguiente etapa por lo que se debe traer el saldo del jugador, la apuesta de la etapa y la veriifcacion de la adivinanza del jugador. 

VerifyExistenceOfWinnerAtGame: Este caso de uso se aplicará al final de cada ronda validando que los jugadores tengan un saldo para poder apostar, y asi mismo puedan mantener la apuesta de la ronda. Al igual que poder evaluar si la cantidad de jugadores es apta para empezar una nueva ronda. Debemos traer el saldo de cada jugador y verificar que este sea mayor a 0.

SetBet: En este caso de uso se va a evaluar la apuesta de cada jugador y se verificará si de acuerdo a su saldo puede apostar esa cantidad. También se generará el acumuilado de la apuesta de la ronda. 

FirstStage: En este caso de uso se destaparán las caras de los 3 primeros dados, y se hara las validaciones de las adivinanzas de cada jugador para comprobar si cada una de  estas se puede cumplir o no según las condiciones de la etapa. 

SecondStage: En este caso de uso se destaparán las caras de 2 dados, y se hara las validaciones de las adivinanzas de cada jugador para comprobar si cada una de  estas se puede cumplir o no según las condiciones de la etapa. 

FirstStage: En este caso de uso se destapará la cara del ultimo dado, y se hara las validaciones de las adivinanzas de cada jugador para comprobar si cada una de  estas se puede cumplir o no según las condiciones de la etapa. 
