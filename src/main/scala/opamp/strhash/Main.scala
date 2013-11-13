package opamp.strhash

import java.security.MessageDigest;

object Main {
  def main(args: Array[String]){
    if(args.length != 2){
        Console.err.println("INVALID INPUTS")
        System.exit(1)
    }
    val alg:String = args(0)
    val str:String = args(1)
    Console.err.println(s"ALGORITHM:$alg  INPUT:$str")

    val md:MessageDigest = try{ MessageDigest.getInstance(alg) } catch { case e:java.security.NoSuchAlgorithmException => 
      Console.err.println("ERROR:Your Input algorithm is invalid. AUTO CHOOSE -> MD5")
      MessageDigest.getInstance("MD5")
    }

    md.update(str.getBytes)

    var sb = new StringBuffer()
    md.digest.foreach(b => sb.append(Integer.toString((b & 0xff) + 0x100,16).substring(1)))
    println(sb.toString)
  }
}
