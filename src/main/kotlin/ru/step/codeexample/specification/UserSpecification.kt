package ru.step.codeexample.specification

import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import ru.step.codeexample.model.User
import ru.step.codeexample.model.dto.UserRequestDto

@Component
class UserSpecification {
    fun getFilter(request: UserRequestDto): Specification<User> {
        return Specification.where(attributeEquals("firstName", request.firstName))
                .and(attributeEquals("secondName", request.secondName))
    }

    /**
     * Метод для получения спецификации по полю объекта на основе точного соответствия.
     *
     * @attributeName имя атрибута для построения критерия
     * @value значение атрибута для сравнения
     * @return спецификации жля фильтрации
     */
    private fun <T> attributeEquals(attributeName: String, value: T?): Specification<User> {
        return Specification { root, query, criteriaBuilder ->
            value?.let {
                criteriaBuilder.equal(
                        root.get<T>(attributeName),
                        value)
            }
        }
    }
}