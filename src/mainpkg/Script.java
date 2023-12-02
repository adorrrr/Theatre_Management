package mainpkg;

import java.io.Serializable;



public class Script implements Serializable{
    protected String writer;
    protected String showsName;
    protected String script;

    public Script(String writer, String showsName, String script) {
        this.writer = writer;
        this.showsName = showsName;
        this.script = script;
    }

    public String getWriter() {
        return writer;
    }

    public String getShowsName() {
        return showsName;
    }

    public String getScript() {
        return script;
    }
    
}
