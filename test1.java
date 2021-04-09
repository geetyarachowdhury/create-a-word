import java.io.*; 
import java.util.regex.*; 
import java.util.ArrayList;
import java.util.*;
class read1
{ 
static int charLimit = 2;
static char rChar[] = new char[10]; 
public static char[] showRandomChar() {
		for(int i=0;i<10;i++) {
        Random rnd = new Random();
		char c = (char) (rnd.nextInt(26) + 'a');
		rChar[i]=c;
		}
		for(int i=0;i<10;i++) {
			System.out.print(rChar[i] + " ");
		}
		System.out.println();
		return rChar;
	} 
public static void main(String[] args)throws Exception 
{ 

int error = 0, level = 1;
File file = new File("word.txt"); 

BufferedReader br = new BufferedReader(new FileReader(file)); 
ArrayList<String> ls = new ArrayList<>();

String st;
Pattern p = Pattern.compile("\"([^\"]*)\""); 
while ((st = br.readLine()) != null) {	
	
	Matcher m = p.matcher(st);
	while (m.find()) {
  	ls.add(m.group(1));
} 
}
Scanner sc = new Scanner(System.in);
while(error!=3 && level != 4) {
	char []temp=showRandomChar();
	char []temp1=new char[10];
	System.out.println("choose any "+charLimit+" characters to make a word: " );
	String inWord1 = sc.nextLine();
	String inWord=inWord1.toLowerCase();
	for(int i=0;i<inWord.length();i++)
		 temp1[i]=inWord.charAt(i);
	if(inWord.length()==charLimit){
		boolean check=false;
		for(int i=0;i<charLimit;i++){
			for(int j=0;j<10;j++){
				if(temp1[i]==temp[j]){
					check=true;
					break;
				}
				else
					check=false;
			}
			if(check==false)
				break;
				
			}
		if(check==true){
		boolean ans = ls.contains(inWord ); 
  
        if (ans) {
			if(level==3) {
					level++;
					System.out.println("Congratulations you have finished all the levels");
				} 
				else {
					System.out.println("Congratulations! level up!");
					charLimit++;
					level++;
					System.out.println("You are now in level "+level);
				}
			
			}
		}
		else{
			error++;
			System.out.println("characters not found");
			System.out.println("only " + (3-error) +" chances left");
		}
		}
	else{
		error++;
				if(error==3){
					System.out.println("Sorry Game Over");
				}
				else {
				System.out.println("please select "+charLimit+" characters. only " + (3-error) +" chances left");
			}
		}
	}
}
}