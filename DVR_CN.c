#include <stdio.h>
int min(int,int);
void table(int [][30],int,int);
int main()
{
    int num, cost[30][30], i,j,k;
    printf("enter number of routers\n");
    scanf("%d", &num);
    printf("enter delays between routers\n");
    for (i = 0; i < num; i++)
    {
        for (j = 0; j < num; j++)
        {
            scanf("%d", &cost[i][j]);
        }
    }

    printf("A's table initially\n");
    for (i = 0; i < num; i++)
    {
        printf("%d\n", cost[0][i]);
    }

    printf("B's table initially\n");
    for (i = 0; i < num; i++)
    {
        printf("%d\n", cost[1][i]);
    }

    printf("C's table initially\n");
    for (i = 0; i < num; i++)
    {
        printf("%d\n", cost[2][i]);
    }

    printf("D's table initially\n");
    for (i = 0; i < num; i++)
    {
        printf("%d\n", cost[3][i]);
    }

    for(i = 0;i< num;i++)
    {
        table(cost,i,num);
    }
    

    
}

int min(int a,int b)
{
    return(a>b)?b:a;
}

void table(int cost[30][30], int i,int num)
{
    int A1[num],A2[num];
    int j,k,l;
    for (l = 0; l < num; l++)
    {
        
        if (cost[i][l] != 0 && cost[i][l] != 99)
        {
            printf("neighbour of %d is %d\n", i+1,l + 1);
            for (j = 0; j < num; j++)
            {
                if (cost[l][j] != 99 && cost[i][j] != 99)
                {
                    A1[j] = cost[i][j] + min(cost[l][j],cost[i][j]);
                }
                else if(cost[i][j] == 99 && cost[l][j] != 99 )
                {
                    
                    A1[j] = cost[i][l] + min(cost[l][j],cost[i][j]);
                }
                else if(cost[i][j] != 99 && cost[l][j] == 99) 
                {
                    A1[j] = min(cost[l][j],cost[i][j]);
                }
            }

            for (k = 0; k < num; k++)
            {
                A2[k] = A1[k];
            }
            printf("new table is\n");
            for(k = 0;k<num;k++)
            {
                printf("%d\n",min(A1[k],A2[k]));
            }
        }
    
    }
}