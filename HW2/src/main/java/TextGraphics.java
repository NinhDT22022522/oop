public class TextGraphics {

    private static TextGraphics instance;
    private char[][] buffer = new char[][]{
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
    };
    private int width = 10;  //chieu rong
    private int height = 10; //chieu cao

    private TextGraphics(){

    }

    public static TextGraphics getInstance(){
        if (instance == null) {
            instance = new TextGraphics();
        }
        return  instance;
    }

    public void init(int width, int height){
        this.width = width;
        this.height = height;
        this.buffer = new char[height][width];
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                buffer[i][j] = ' ';
            }
        }
    }

    public void drawPoint(char c, int x, int y){
        if (x >= 0 && x < height && y >= 0 && y < width) {
            this.buffer[x][y] = c;
        }
    }

    public void drawLine(char c, int x1, int y1, int x2, int y2){
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2? 1 : -1;
        int sy = y1 < y2? 1 : -1;
        int err = dx - dy;

        while(true){
            drawPoint(c, x1, y1);
            if (x1 == x2 && y1 == y2) break;

            int e2 = err * 2;
            if (e2 > -dy){
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx){
                err += dx;
                y1 += sy;
            }
        }
    }

    public void fillRect(char c ,int x, int y, int width, int height){
        for (int i = x; i < x + height; i++){
            for (int j = y; j < y + width; j++){
                this.buffer[i][j] = c;
            }
        }
    }

    public void render(){
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                System.out.print(this.buffer[i][j]);
            }
            System.out.println();
        }
    }

    public void clear(){
        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                buffer[i][j] = ' ';
            }

        }
    }

    public static void main(String[] args) {
        TextGraphics graphics = TextGraphics.getInstance();
        graphics.init(15, 10);
        graphics.drawPoint('*', 1,1);
        graphics.fillRect('o', 5, 5, 3, 2);
        graphics.render();

    }
}
