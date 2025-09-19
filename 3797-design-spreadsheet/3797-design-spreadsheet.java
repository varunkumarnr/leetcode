class Spreadsheet {
    /* 
        have a 2d Array 0 - 25 A -z cols 
        n rows 

        initially its 0

        set cell get value 

        getValue ya 

        rest cell ya 

    */
    int[][] grid; 
    public Spreadsheet(int rows) {
        grid = new int[rows+1][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A'; 
        int row = Integer.valueOf(cell.substring(1)); 
        grid[row][col] = value; 
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A'; 
        int row = Integer.valueOf(cell.substring(1)); 
        grid[row][col] = 0; 
    }
    
    public int getValue(String formula) {
        String newString = formula.substring(1); 
        String[] s = newString.split("\\+"); 
        int num1 = 0; 
        int num2 = 0; 
        if(Character.isLetter(s[0].charAt(0)))  { 
            int col = s[0].charAt(0) - 'A'; 
            int row = Integer.valueOf(s[0].substring(1)); 
            num1 = grid[row][col]; 
        } else  { 
            num1 =  Integer.valueOf(s[0]); 
        }
        if(Character.isLetter(s[1].charAt(0)))  { 
            int  col =  s[1].charAt(0) - 'A'; 
            int row =  Integer.valueOf(s[1].substring(1)); 
            num2 = grid[row][col]; 
        } else  { 
            num2 =  Integer.valueOf(s[1]); 
        }
        return num1 + num2; 
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */