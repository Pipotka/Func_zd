fun main(args: Array<String>)
{
    print("Введите сообщение: ")
    var input = readln().lowercase()
    if((input.length % 2) == 1)
    {
        input += 'я'
    }
    var chunks = input.chunked(2)
    var strCodes : ArrayList<String> = ArrayList()
    for(twoChars in chunks)
    {
        var firstCode = determineChar(twoChars[0])
        var secondCode = determineChar(twoChars[1])
        var result = secondCode + (firstCode - 1) * 31
        strCodes.add(codeToString(result))
    }
    for(twoChars in chunks)
    {
        print("$twoChars ")
    }
    println()
    for(strCode in strCodes)
    {
        print("$strCode ")
    }
    println()
    for(strCode in strCodes)
    {
        var code = stringToCode(strCode)
        val columnCount = 31
        var firstChar = 'a'
        var secondChar = 'a'
        for(currentRow in 0..30)
        {
            var nextRow = currentRow + 1
            if((currentRow * columnCount < code) && (nextRow * columnCount >= code))
            {
                for(column in 1..columnCount)
                {
                    if((currentRow * columnCount + column) == code)
                    {
                        firstChar = determineCode(currentRow + 1)
                        secondChar = determineCode(column)

                        print("$firstChar$secondChar ")
                        break
                    }
                }
                break
            }
        }
    }
}

fun determineCode(Response : Int): Char
{
    var code = Response
    var result : Char = 'a'
    when(code)
    {
        1 -> result = 'а'
        2 -> result ='б'
        3 -> result ='в'
        4 -> result ='г'
        5 -> result ='д'
        6 -> result ='е'
        7 -> result ='ж'
        8 -> result ='з'
        9 -> result ='и'
        10 -> result ='к'
        11 -> result ='л'
        12 -> result ='м'
        13 -> result ='н'
        14 -> result ='о'
        15 -> result ='п'
        16 -> result ='р'
        17 -> result ='с'
        18 -> result ='т'
        19 -> result ='у'
        20 -> result ='ф'
        21 -> result ='х'
        22 -> result ='ц'
        23 -> result ='ч'
        24 -> result ='ш'
        25 -> result ='щ'
        26 -> result ='ъ'
        27 -> result ='ы'
        28 -> result ='ь'
        29 -> result ='э'
        30 -> result ='ю'
        31 -> result ='я'
    }
    return result
}

fun determineChar(Response : Char): Int
{
    var ch = Response
    if (ch == 'ё')
    {
        ch = 'е'
    }
    if (ch == 'й')
    {
        ch = 'и'
    }
    var result : Int = 0
    when(ch)
    {
        'а' -> result = 1
        'б' -> result =2
        'в' -> result =3
        'г' -> result =4
        'д' -> result =5
        'е' -> result =6
        'ж' -> result =7
        'з' -> result =8
        'и' -> result =9
        'к' -> result =10
        'л' -> result =11
        'м' -> result =12
        'н' -> result =13
        'о' -> result =14
        'п' -> result =15
        'р' -> result =16
        'с' -> result =17
        'т' -> result =18
        'у' -> result =19
        'ф' -> result =20
        'х' -> result =21
        'ц' -> result =22
        'ч' -> result =23
        'ш' -> result =24
        'щ' -> result =25
        'ъ' -> result =26
        'ы' -> result =27
        'ь' -> result =28
        'э' -> result =29
        'ю' -> result =30
        'я' -> result =31
    }
    return result
}

fun codeToString(code : Int) : String
{
    var result = code.toString()
    if (code < 100)
    {
        if (code < 10)
        {
            result = "0$result"
        }
        result = "0$result"
    }
    return result
}

fun stringToCode(strCode : String) : Int
{
    var strResult = ""
    for(chr in strCode)
    {
        if(chr != '0')
        {
            strResult += chr
        }
    }
    var result = strResult.toInt()
    return result
}