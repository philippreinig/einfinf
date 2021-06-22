mult(x, y) =
if y = 0 then 0
else x + mult(x, y - 1)
fi

x = beliebig, y >= 0

1) Induktionsanfang:
y0 = 0;
mult(x,y0) = mult(x,0) = 0 = x*0 = x*y0

2) Induktionsvoraussetzung:
Für alle y0<=z<=y gilt mult(x,z) = x*z
   
3) Induktionsschritt:
mult(x,y+1) = x + mult(x,y+1-1) = x + mult(x,y) =IV= x + x * y = x * (y + 1)

q.e.d.   