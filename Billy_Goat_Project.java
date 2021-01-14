import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Billy_Goat_Project extends JApplet implements MouseListener, ActionListener
{
	int x1;
	int x2;
	int x3;
	int y1;
	int y2;
	int y3;
	int counter = 0;
	//distance formula broken up
	double sideA = 0;
	double sideB = 0;
	double sideC = 0;
	double difx1;
	double dify1;
	double rootx1;
	double rooty1;
	double difx2;
	double dify2;
	double rootx2;
	double rooty2;
	double difx3;
	double dify3;
	double rootx3;
	double rooty3;
	double side1;
	double side2;
	double side3;
	//end of distance formula
	double perimeter;
	JLabel P;
	JButton R;


	public void init()
		{
			setContentPane(new drawingPanel());
			addMouseListener(this);
			P = new JLabel ("" + perimeter);
			R = new JButton("Reset");
			R.addActionListener(this);
			add(P);
			add(R);
		}
	public class drawingPanel extends JPanel
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				//regulates when things are drawn
				if(counter == 0)
					{
					}
				else if (counter == 1)
					{
						g.drawOval(x1-10,y1-10,20,20);
					}
				else if (counter == 2)
					{
						g.drawOval(x1-10,y1-10,20,20);
						g.drawOval(x2-10,y2-10,20,20);
						g.drawLine(x1,y1,x2,y2);
					}
				else if (counter == 3)
					{
						g.drawOval(x1-10,y1-10,20,20);
						g.drawOval(x2-10,y2-10,20,20);
						g.drawLine(x1,y1,x2,y2);
						g.drawOval(x3-10,y3-10,20,20);
						g.drawLine(x2,y2,x3,y3);
						g.drawLine(x1,y1,x3,y3);
					}
				//each piece of the distance formula
				difx1 = (x2-x1)*(x2-x1);
				dify1 = (y2-y1)*(y2-y1);

				rootx1 = Math.sqrt(difx1);
				rooty1 = Math.sqrt(dify1);

				side1 = rootx1 + rooty1;

				difx2 = (x2-x3)*(x2-x3);
				dify2 = (y2-y3)*(y2-y3);

				rootx2 = Math.sqrt(difx2);
				rooty2 = Math.sqrt(dify2);

				side2 = rootx2 + rooty2;

				difx3 = (x1-x3)*(x1-x3);
				dify3 = (y1-y3)*(y1-y3);

				rootx3 = Math.sqrt(difx2);
				rooty3 = Math.sqrt(dify2);

				side3 = rootx3 + rooty3;
				//end of distance formula equations

				perimeter = side1 + side2 + side3;

				repaint();
			}
		}
	public void actionPerformed(ActionEvent e)
		{
			//R = reset button, use to reset the click inputs
			if(e.getSource() == R)
				{
					//P = perimeter
					P.setText("" + 0);
					counter = 0;
					repaint();
				}
		}
	public void mouseClicked (MouseEvent e)
		{
			if(counter == 0)
				{
					//first point
					x1 = e.getX();
					y1 = e.getY();
					counter++;
				}
			else if(counter == 1)
				{
					//2nd
					x2 = e.getX();
					y2 = e.getY();
					counter++;
				}
			else if(counter == 2)
				{
					//3rd
					x3 = e.getX();
					y3 = e.getY();
					counter++;

					P.setText("" + perimeter);
				}
			//nothing happens after 3rd click use reset button to create a new triangle
			else if(counter == 3)
			{

			}
		}
	public void mousePressed (MouseEvent e)
		{
		}
	public void mouseReleased (MouseEvent e)
		{
		}
	public void mouseEntered (MouseEvent e)
		{
		}
	public void mouseExited (MouseEvent e)
		{
		}
}