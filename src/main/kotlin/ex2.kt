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
        var firstCode = determine(twoChars[0])
        var secondCode = determine(twoChars[1])
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
        if ((code in 31..961 step 31) && (strCode == strCodes[strCodes.lastIndex]))
        {

        }
    }
}

fun determine(Response : Char): Int
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