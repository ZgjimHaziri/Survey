import javax.swing.*;

public class Drawing
{
    static int sLength = 10;
    static int uLength = 100;

    String[][] answers = new String[uLength][sLength];
    Survey surv = new Survey();
    String survey_name = "";
    String[] users_name = new String[uLength];
    int choosed_user=0;

    public void createSurvey()
    {
        String s ="";
        survey_name = JOptionPane.showInputDialog("Name your survey: ") + ":";
        for(int i=0;i<sLength;i++)
        {
            s = JOptionPane.showInputDialog("Add a question to the survey : ");
            surv.addQuestion(s);
        }
    }

    public void takeASurvey(int user)
    {
        users_name[user] = JOptionPane.showInputDialog("Users's name: ") + ":";
        for(int i=0; i<sLength;i++)
        {
            String s = JOptionPane.showInputDialog(surv.questions[i]);
            addAnAnswer(s,user);
        }
    }

    public void addAnAnswer(String s,int user)
    {
        for(int i=0;i<answers[0].length;i++)
        {
            if(answers[user][i]==null)
            {
                answers[user][i]= s;
                break;
            }
        }
    }

    public void surveyLength()
    {
        while (true)
        {
            String survey = JOptionPane.showInputDialog("How many questions do you want your survey to have?(max 10)");
            String users_length = JOptionPane.showInputDialog("How many users ?");

            if (isNumeric(survey) && isNumeric(users_length))
            {
                int survey_length = Integer.parseInt(survey);
                int users = Integer.parseInt(users_length);

                if((survey_length <= 10 && survey_length > 0) && users > 0)
                {
                    sLength = survey_length;
                    uLength = users;
                    break;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error: number out of range!");
                }
            }
        }
    }

    public  boolean isNumeric(String str)
    {
        boolean rez = true;

        if(str==null)
        {
            rez= false;
            JOptionPane.showMessageDialog(null,"Error: you pressed the cancel button!");
            System.exit(0);
        }
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            rez= false;
            JOptionPane.showMessageDialog(null, "Error: you typed text instead of a number!");
            System.exit(0);
        }
        return rez;
    }

    public void chooseAnAction()
    {
        String number = JOptionPane.showInputDialog("Which user do you want to see?" + surv.optionString() + "\nPress -1 to end the program.");
        if (isNumeric(number))
        {
            int a = Integer.parseInt(number);
            if (a >= -1 && a < uLength)
            {
                if (a != -1)
                {
                    choosed_user = a;
                } else
                {
                    System.exit(0);
                }
            } else
            {
                JOptionPane.showMessageDialog(null, "Error: number out of range!");
                chooseAnAction();
            }
        }
    }
}