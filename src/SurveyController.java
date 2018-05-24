public class SurveyController
{
    public static void main(String[] args)
    {
        SurveyView obj = new SurveyView(525, 550);
        obj.a.surveyLength();
        obj.a.createSurvey();
        for (int i = 0; i < Drawing.uLength; i++)
        {
            obj.a.takeASurvey(i);
        }
        while(true)
        {
            obj.a.chooseAnAction();
            obj.frame.setVisible(true);
        }
    }
}
