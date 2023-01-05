package cyou.joiplay.commons.model;

public class RuffleConfiguration {
    public int screenTimeout = 0;
    public String backend = "opengl"; //vulkan, opengl
    public String quality = "high"; //low, medium, high, best, 8x8, 8x8linear, 16x16, 16x16linear
    public String scaleMode = "showall"; //exactfit, noborder, noscale, showall
    public String letterbox = "on"; //off, on
    public String loadBehavior = "streaming"; //streaming, delayed, blocking
}
