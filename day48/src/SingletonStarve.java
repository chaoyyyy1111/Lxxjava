public final class SingletonStarve {
private static final SingletonStarve instance;
static {
    instance = new SingletonStarve();
}
public static SingletonStarve getInstance() {
    return instance;
}
private SingletonStarve() {

}
}
