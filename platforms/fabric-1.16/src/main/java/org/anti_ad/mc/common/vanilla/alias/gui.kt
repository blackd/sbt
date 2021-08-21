package org.anti_ad.mc.common.vanilla.alias

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen
import net.minecraft.client.gui.screen.ingame.HandledScreen
import net.minecraft.client.gui.widget.AbstractButtonWidget
//import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.widget.SliderWidget
import net.minecraft.client.gui.widget.TextFieldWidget

typealias Screen = Screen
typealias ContainerScreen<T> = HandledScreen<T>
typealias CreativeInventoryScreen = CreativeInventoryScreen

typealias ClickableWidget = AbstractButtonWidget
//typealias Selectable = Selectable
typealias SliderWidget = SliderWidget
typealias TextFieldWidget = TextFieldWidget
