package styler.weld.rendering.viewholder

class WidgetFactory {

    let factories = List<Factory>();

    void register(factory) {}

    BaseViewHolder createViewHolder(parent, viewType) {
        return viewFactories[viewType].create(parent)
    }
}