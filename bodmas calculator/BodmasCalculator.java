import java.util.Scanner;

public class BodmasCalculator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            System.out.print("Enter an expression (or -1 to exit): ");
            String input = scan.nextLine();
            if (input.equals("-1")) {
                break;
            }

            System.out.print("Result: " + calculate(input) + "\n");
        }
    }

    public static int calculate (String inp)
    {
        boolean terminate=false;

        // input only contains negative number
        if(!inp.contains("/") && !inp.contains("*") && !inp.contains("+") && inp.charAt(0)=='-'){
            inp = "0"+inp;
        }

        // input starts with an operator
        char c = inp.charAt(0);
        if((c=='/' || c=='*' || c=='+') && !terminate){
            if(c=='+'){
                inp = "0"+inp;
            }   
            else{
                System.out.println("The input cannot start with an operator!");
                return 0;
            }   
        }

        // input contains no operations
        if(!inp.contains("/") && !inp.contains("*") && !inp.contains("+") && !inp.contains("-") && !terminate){
            System.out.println("The input must contain an operation!");
            return Integer.parseInt(inp);
        }

        // input doesnt contain a number after a symbol
        if(!Character.isDigit(inp.charAt(inp.length()-1)) && !terminate){
            System.out.println("Only numbers are allowed!");
            return 0;
        }
        String sampler = "";

        // input contains 2 consecutive symbols
        for(int i=0; i<inp.length()-1; i++){
            if(!Character.isDigit(inp.charAt(i)) && !Character.isDigit(inp.charAt(i+1)) && !terminate){
                if((inp.charAt(i)=='+' && inp.charAt(i+1)=='-')||(inp.charAt(i)=='-' && inp.charAt(i+1)=='+')){ 
                    int j = 0;
                    while(j<inp.length()){
                        if(j==i){
                            sampler += "-";
                            j=j+2; continue;
                        }
                        sampler += inp.charAt(j); 
                        j++;
                    }
                    inp = sampler;
                }
                else if(inp.charAt(i)=='-' && inp.charAt(i+1)=='-'){ 
                    int j = 0;
                    while(j<inp.length()){
                        if(j==i){
                            sampler += "+";
                            j=j+2; continue;
                        }
                        sampler += inp.charAt(j); 
                        j++;
                    }
                    inp = sampler;
                }
                else{
                    terminate = true;
                    System.out.println("Two consecutive operators are not allowed!");
                    return 0;
                }
            }
        }

        for(int i=0; i<4; i++)
        {
            char[] list = {'/', '*', '+', '-'};

            while(inp.indexOf(list[i]) != -1 && !terminate)
            {
                int indexI = inp.indexOf(list[i]);
                int i1=indexI-1, i2=indexI+1;
                String num1="", num2="";

                // if negative sign is at start
                if(i==3 && indexI==0){
                    // skip the negative and set indexI to the index of next negative
                    for(int j=1; j<inp.length(); j++)
                    {
                        if(inp.charAt(j) == '-')
                        {
                            indexI = j;
                            i1=indexI-1; i2=indexI+1;
                            break;
                        }
                    }
                }

                // store the number to the left of operator in 'num1'
                while(i1 != -1)
                {
                    char ch = inp.charAt(i1);
                    if(ch=='/' || ch== '*' || ch== '+' || ch== '-')
                        break;
                    num1 += ch;
                    i1--;
                }
                // store the number to the right of operator in 'num2'
                while(i2 < inp.length())
                {
                    char ch = inp.charAt(i2);
                    if(ch=='/' || ch== '*' || ch== '+' || ch== '-')
                        break;
                    num2 += ch;
                    i2++;
                }

                // convert string to int, reverse num1 (number on the left of the operator)
                String rev1="", rev2="";
                float n1, n2, n=0;
                for(int j=num1.length()-1; j>=0; j--)
                    rev1+=num1.charAt(j);

                n1 = Float.parseFloat(rev1);
                n2 = Float.parseFloat(num2);

                switch(list[i])
                {
                    case '/':
                        n=n1/n2;
                        break;
                    case '*':
                        n=n1*n2;
                        break;
                    case '+':
                        boolean negative = false;
                        int k=indexI-1;
                        if(k==0)
                            n=n1+n2;

                        if(inp.substring(0,k).indexOf('-')!=-1)
                        {
                            while(k>0)
                            {
                                k--;
                                char ch = inp.charAt(k);
                                if(ch=='*' || ch=='/' || ch=='+')
                                {
                                    n = n1+n2;
                                    break;
                                }
                                else if(ch=='-')
                                {
                                    // found negative
                                    negative = true;
                                    break;
                                }
                            }
                            if(negative)
                            {
                                negative = false;
                                if(n2>n1)
                                {
                                    n = n2-n1;
                                    i1--;
                                }
                                else
                                {
                                    n = n1-n2;
                                    if(k==0 && inp.indexOf('-')==inp.lastIndexOf('-'))
                                    {
                                        n = (float)Math.round(n * 1000f) / 1000f;
                                        inp = "-"+Float.toString(n);
                                        terminate = true;
                                        continue;
                                    }
                                }
                            }
                        }else
                            n=n1+n2;
                        break;

                    case '-':
                        if(inp.indexOf('-')==inp.lastIndexOf('-'))
                        {
                            // only one - remains
                            n = n1 - n2;
                            n = (float)Math.round(n * 1000f) / 1000f;
                            inp = Float.toString(n);
                            terminate = true;
                            continue;
                        }
                        else
                        {
                            // more than one -
                            int count = inp.length() - inp.replace("-","").length();
                            if(inp.charAt(0)=='-' && count==2)
                            {
                                // only one - at start
                                n = n1 + n2;
                                n = (float)Math.round(n * 1000f) / 1000f;
                                inp = "-"+Float.toString(n);
                                terminate = true;
                                continue;
                            }else if(inp.charAt(0)=='-'){
                                // more than one -, and one at start
                                n = Math.abs(n1)+Math.abs(n2);
                            }else{
                                // more than one -, none at start
                                n = n1 - n2;
                            }
                        }
                }

                // round off the result
                n = (float)Math.round(n * 1000f) / 1000f;

                // store the new equation, replacing the operators and operands with the result
                inp = inp.substring(0,i1+1) + n + inp.substring(i2);
            }
        }

        // removing extra 0s
        if(inp.charAt(inp.length()-1)=='0' && inp.charAt(inp.length()-2)=='.')
            inp = inp.substring(0,inp.length()-2);

        return Integer.parseInt(inp);
    }
}