class grid
{
     
static final int r = 4;
static final int c = 4;
static boolean findmatch(char mat[][], String pat, int x, int y,
                        int nrow, int ncol, int level)
{
    int l = pat.length();
    if (level == l)
        return true;
    if (x < 0 || y < 0 || x >= nrow || y >= ncol)
        return false;
    if (mat[x][y] == pat.charAt(level))
    {

        char temp = mat[x][y];
        mat[x][y] = '#';
 
        boolean res = findmatch(mat, pat, x - 1, y, nrow, ncol, level + 1) |
                    findmatch(mat, pat, x + 1, y, nrow, ncol, level + 1) |
                    findmatch(mat, pat, x, y - 1, nrow, ncol, level + 1) |
                    findmatch(mat, pat, x, y + 1, nrow, ncol, level + 1);
        mat[x][y] = temp;
        return res;
    }
    else 
        return false;
}

static boolean checkMatch(char mat[][], String pat, int nrow, int ncol)
{
 
    int l = pat.length();

    if (l > nrow * ncol)
        return false;
 
    for (int i = 0; i < nrow; i++)
    {
        for (int j = 0; j < ncol; j++)
        {
            if (mat[i][j] == pat.charAt(0))
                if (findmatch(mat, pat, i, j, nrow, ncol, 0))
                    return true;
        }
    }
    return false;
}
 
public static void main(String[] args)
{
    char grid[][] = { "axmy".toCharArray(),
                        "bgdf".toCharArray(),
                        "xeet".toCharArray(),
                        "raks".toCharArray() };
    if (checkMatch(grid, "geeks", r, c))
        System.out.print("Yes");
    else
        System.out.print("No");
}
}