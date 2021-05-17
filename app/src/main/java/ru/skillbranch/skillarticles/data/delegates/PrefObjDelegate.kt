package ru.skillbranch.skillarticles.data.delegates

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.skillbranch.skillarticles.data.PrefManager
import ru.skillbranch.skillarticles.data.adapters.JsonAdapter
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PrefObjDelegate<T>(
    private val adapter: JsonAdapter<T>,
    private val customKey: String? = null
) : ReadWriteProperty<PrefManager, T?> {

    private var _storedValue: T? = null

    override fun setValue(thisRef: PrefManager, property: KProperty<*>, value: T?) {
        _storedValue = value
        thisRef.scope.launch {
            thisRef.dataStore.edit { prefs ->
                prefs[keyName(property)] = value.let(adapter::toJson)
            }
        }
    }

    override fun getValue(thisRef: PrefManager, property: KProperty<*>): T? {
        if (_storedValue == null) {
            val flowValue = thisRef.dataStore.data
                .map { prefs ->
                    prefs[keyName(property)]?.let(adapter::fromJson)
                }
            _storedValue = runBlocking(Dispatchers.IO) { flowValue.first() }
        }
        return _storedValue
    }

    private fun keyName(property: KProperty<*>) = stringPreferencesKey(customKey ?: property.name)

}
