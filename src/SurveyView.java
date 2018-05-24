import javax.swing.*;
import java.awt.*;

public class SurveyView extends JPanel
{
    JFrame frame = new JFrame();
    static int height;
    static int width;
    private static final int CELL_WIDTH= 230;
    private static final int CELL_HEIGHT = 40;
    Drawing a = new Drawing();

    public SurveyView(int w,int h)
    {
        width = w;
        height = h;
        frame.getContentPane().add(this);
        frame.setSize(width,height);
        frame.setTitle("Surveys");
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        drawASurvey(g, a.surv.questions, a.survey_name);
        drawAUser(g, a.answers, a.users_name[a.choosed_user], a.choosed_user);
    }


    public void drawASurvey(Graphics g, String[] a, String title)
    {
        g.setColor(Color.black);
        g.drawRect(10, 10, CELL_WIDTH, CELL_HEIGHT);
        g.drawString(title,15,30);
        for(int i=0;i<a.length;i++)
        {
            if (a[i] != null)
            {
                g.setColor(Color.GRAY);
                g.fillRect(10, CELL_HEIGHT * i + 50, CELL_WIDTH, CELL_HEIGHT);
                g.setColor(Color.black);
                g.drawRect(10, CELL_HEIGHT * i + 50, CELL_WIDTH, CELL_HEIGHT);
                g.drawString(a[i],15, CELL_HEIGHT*i + 70);
            }
        }
        this.repaint();
    }

    public void drawAUser(Graphics g, String[][] a,String title,int user)
    {
        g.setColor(Color.black);
        g.drawRect(CELL_WIDTH+ 10, 10, CELL_WIDTH, CELL_HEIGHT);
        if(title != null)
        {
            g.drawString(title,CELL_WIDTH + 15, 30);
        }
        for(int i=0;i<a[0].length;i++)
        {
            if (a[user][i] != null)
            {
                g.setColor(Color.green);
                g.fillRect(CELL_WIDTH + 10, CELL_HEIGHT * i + 50, CELL_WIDTH, 40);
                g.setColor(Color.black);
                g.drawRect(CELL_WIDTH + 10, CELL_HEIGHT * i + 50, CELL_WIDTH, 40);
                g.drawString(a[user][i],CELL_WIDTH + 15, CELL_HEIGHT*i + 70);
            }
        }
        this.repaint();
    }
}