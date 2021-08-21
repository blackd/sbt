package org.anti_ad.mc.sbt.common.config

fun List<IConfigOption>.toMultiConfig(): CategorizedMultiConfig =
    CategorizedMultiConfig().apply { forEach { addConfigOption(it) } }

class CategorizedMultiConfig : ConfigOptionBase(), IConfigElementResettableMultiple {
    val categories = mutableListOf<Pair<String, List<IConfigOption>>>()
    private var currentCategory: MutableList<IConfigOption>? = null

    fun addCategory(categoryName: String) = mutableListOf<IConfigOption>().also {
        currentCategory = it
        categories += categoryName to it
    }

    fun addConfigOption(configOption: IConfigOption) {
        (currentCategory ?: addCategory("")).add(configOption)
    }

    override fun getConfigOptionMap() = getConfigOptionMapFromList()
    override fun getConfigOptionList() = categories.flatMap { it.second }
}