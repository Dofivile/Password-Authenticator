import java.util.ArrayList;



public class PasswordCheckerUtility {


private String password;

private String passwordConfirm;


public PasswordCheckerUtility(String password, String passwordConfirm) {


this.password=password;

this.passwordConfirm=passwordConfirm;


}


public static void comparePasswords(String password, String passwordConfirm ) throws UnmatchedException {


if( !(password.equals(passwordConfirm))) {

throw new UnmatchedException();

}


}


public static boolean comparePasswordsWithReturn (String password, String passwordConfirm ) {


return password.equals(passwordConfirm);

}


public static boolean isValidLength(String password) throws LengthException{


if(password.length()<6) 

throw new LengthException();


return true;


}


public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{ 


int count=0;


for(int i=0;i<password.length();++i) {


if(Character.isUpperCase(password.charAt(i))) {

count++;

}


}

if(count<1) {

throw new NoUpperAlphaException();

}

return true;

}


public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException{



int count=0;


for(int i=0;i<password.length();++i) {


if(Character.isLowerCase(password.charAt(i))) {

count++;

}


}

if(count<1) {

throw new NoLowerAlphaException();

}

return true;

}


public static boolean hasDigit​(String password) throws NoDigitException{



int count=0;


for(int i=0;i<password.length();++i) {


if(Character.isDigit(password.charAt(i))) {

count++;

}


}

if(count<1) {

throw new NoDigitException();

}

return true;

}


public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException{


int count=0;


for(int i=0;i<password.length();++i) {


if(!Character.isDigit(password.charAt(i))&& !Character.isLetter(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {

count++;

}


}

if(count<1) {

throw new NoSpecialCharacterException();

}

return true;

}




public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException{



int count=1;


for(int i=0;i<password.length()-1;++i) {


if(password.charAt(i)== password.charAt(i+1)) {

count++;


if(count>2) {

throw new InvalidSequenceException();

}

}else {

count=1;

}

}


return true;


}



public static boolean isPassValid(String password) {


int count=0;


if(password.length()<6) {

return false;

}



// Checks if password contains at least one Alpha Character 

for(int i=0;i<password.length();++i) {



if(Character.isUpperCase(password.charAt(i))) {

count++;

}



}

if(count<1) {

return false;

}




// Checks if password contains at least one lower case letter 

count=0;



for(int i=0;i<password.length();++i) {



if(Character.isLowerCase(password.charAt(i))) {

count++;

}



}

if(count<1) {

return false;

}




//Checks if password contains at least one digit 

count=0;



for(int i=0;i<password.length();++i) {



if(Character.isDigit(password.charAt(i))) {

count++;

}



}

if(count<1) {

return false;

}


// Checks if password contains at least one special char 

count=0;



for(int i=0;i<password.length();++i) {



if(!Character.isDigit(password.charAt(i))&& !Character.isLetter(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {

count++;

}



}

if(count<1) {

return false;

}


// Checks if password meets sequence requirement

        count=1;


for(int i=0;i<password.length()-1;++i) {



if(password.charAt(i)== password.charAt(i+1)) {

count++;

if(count>2) {

return false;

}

}else {

count=1;

}

}



return true;

}


public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{



// Checks if the length of the password is 6 or above 

int count=0;



if(password.length()<6) 

throw new LengthException();


// Checks if password contains at least one Alpha Character 

for(int i=0;i<password.length();++i) {



if(Character.isUpperCase(password.charAt(i))) {

count++;

}



}

if(count<1) {

throw new NoUpperAlphaException();

}

 

// Checks if password contains at least one lower case letter 

count=0;



for(int i=0;i<password.length();++i) {



if(Character.isLowerCase(password.charAt(i))) {

count++;

}



}

if(count<1) {

throw new NoLowerAlphaException();

}


//Checks if password contains at least one digit 

count=0;  



for(int i=0;i<password.length();++i) {



if(Character.isDigit(password.charAt(i))) {

count++;

}



}

if(count<1) {

throw new NoDigitException();

}


// Checks if password contains at least one special char 

count=0;



for(int i=0;i<password.length();++i) {



if(!Character.isDigit(password.charAt(i))&& !Character.isLetter(password.charAt(i)) && !Character.isWhitespace(password.charAt(i))) {

count++;

}



}

if(count<1) {

throw new NoSpecialCharacterException();

}


// Checks if password meets sequence requirement


count=1;


for(int i=0;i<password.length()-1;++i) {



if(password.charAt(i)== password.charAt(i+1)) {

count++;

if(count>2) {

throw new InvalidSequenceException();

}

}else {

count=1;

}

}


return true;

}





public static boolean hasBetweenSixAndNineChars​(String password) {

if(password.length()>=6 && password.length()<=9) {

return true;

}

return false;

}


public static boolean isWeakPassword(String password) throws WeakPasswordException{


if(isPassValid(password) && hasBetweenSixAndNineChars​(password)) {

throw new WeakPasswordException();

 

}

return false;



}


public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){


ArrayList<String> invalid_passwords= new ArrayList<String>();


for(String password: passwords) {


try {

isValidPassword(password);

} catch (LengthException e) {

invalid_passwords.add(password+" "+ e.getMessage());

} catch (NoUpperAlphaException e) {

invalid_passwords.add(password+" "+ e.getMessage());

} catch (NoLowerAlphaException e) {

invalid_passwords.add(password+" "+ e.getMessage());

} catch (NoDigitException e) {

invalid_passwords.add(password+" "+ e.getMessage());

} catch (NoSpecialCharacterException e) {

invalid_passwords.add(password+" "+ e.getMessage());

} catch (InvalidSequenceException e) {

invalid_passwords.add(password+" "+ e.getMessage());

}

}


return invalid_passwords;


}







}

