fun main(args: Array<String>)
{
    println("Камень-Ножницы-Бумага")
    println("1 - камень")
    println("2 - ножницы")
    println("3 - бумага")
    print("Введите свой выбор: ")
    var choosingUser = readln().toInt()
    var choosingOpponent = (0..3).random()
    println("Компьютер выбрал ${ChoiceToString(choosingOpponent)}")
    var result = Judge(choosingUser, choosingOpponent)
    if(result == 0)
        println("Ничья")
    else if(result == -1)
        println("Вы проиграли")
    else if(result == 1)
        println("Вы выйграли")
}
fun Judge(choosingUser: Int, choosingOpponent: Int): Int
{
    var result = 0
    if (choosingUser == choosingOpponent)
    {
        result = 0;
    }
    else if (choosingUser == 1)
    {
        if(choosingOpponent == 2)
        {
            result = 1;
        }
        else
        {
            result = -1;
        }
    }
    else if (choosingUser == 2)
    {
        if(choosingOpponent == 3)
        {
            result = 1;
        }
        else
        {
            result = -1;
        }
    }
    else if (choosingUser == 3)
    {
        if(choosingOpponent == 1)
        {
            result = 1;
        }
        else
        {
            result = -1;
        }
    }
    return result
}

fun ChoiceToString(Choice : Int) : String
{
    var result =""
    when(Choice)
    {
        1 -> result = "камень"
        2 -> result = "ножницы"
        3 -> result = "бумага"
    }
    return result
}