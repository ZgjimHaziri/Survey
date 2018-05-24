public class Survey
{
   String[] questions = new String[Drawing.sLength];

    public void addQuestion(String s)
    {
        for(int i=0;i<questions.length;i++)
        {
            if(questions[i]==null)
            {
                questions[i]=s;
                break;
            }
        }
    }

    public String optionString()
    {
        String s = "(0";
        for (int i = 1; i < Drawing.uLength; i++)
        {
            s += ", " + i;
        }
        s += ")";

        return s;
    }
}