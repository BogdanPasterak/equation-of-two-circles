import math

class Point:
  def __init__(self,x,y):
    self.x=x
    self.y=y
  def display(self,p):
    print("%s ( %.2f, %.2f )"%(p,self.x,self.y))

# Intersection points of two circle.
def equation(A,r,B,R):
  points=[Point(0,0),Point(0,0)]
  # Move the layout to the coordinates of the first circle
  C=Point(B.x-A.x,B.y-A.x)
  a=C.x**2+C.y**2
  # Check whether the sum of radius is not greater than distance
  if math.sqrt(a)<=r+r:
    w=R**2-r**2-a
    b=w*C.y
    c=w**2/4-C.x**2*r**2
    sqrtDelta=math.sqrt(b**2-4*a*c)
    y1=(-b-sqrtDelta)/(2*a)
    y2=(-b+sqrtDelta)/(2*a)
    x1=(C.y*y1+w/2)/-C.x
    x2=(C.y*y2+w/2)/-C.x
    # asigned
    points[0].x=x1+A.x
    points[0].y=y1+A.y
    points[1].x=x2+A.x
    points[1].y=y2+A.y
  return points



# variable
A=Point(4,4)
r=2
B=Point(6,7)
R=4

# calculate
points=equation(A,r,B,R)

#display
points[0].display("G")
points[1].display("H")

