package Factory;

public interface AbstractFactory<T> {
	T create(Model m);
}
