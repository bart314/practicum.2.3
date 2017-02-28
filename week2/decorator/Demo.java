package decorator;

/*
Java transcription from the example at http://bit.ly/2mjNwXA

Example 
Scenario: Let's say you are writing an encryption module. 
This encryption can encrypt the clear file using DES. 
Similarly, in a system you can have the encryption as AES. 
Also, you can have the combination of encryption - 
First DES, then AES. Or you can have first AES, then DES.

Discussion: How will you cater this situation? You cannot 
keep creating the object of such combinations - for example 
AES and DES - total of 4 combinations. Thus, you need to have
4 individual objects This will become complex as the encryption 
type will increase.

Solution: Keep building up the stack - combinations depending 
on the need - at run time. Another advantage of this stack 
approach is that you can unwind it easily.
*/

public class Demo {
	public static void main(String[] args) {
		Encryptable demo = new ClearText("PLAIN TEXT ...");
		System.out.println(demo.getData());
		
		EncryptionDecorator aes = new AESDecorator(demo);
		System.out.println(aes.getData());
		
		EncryptionDecorator des = new DESDecorator(aes);
		System.out.println(des.getData());	
	}
}
