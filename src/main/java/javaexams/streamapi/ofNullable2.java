package javaexams.streamapi;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ofNullable2 {

    public static void main(String[] args) {

        Entity entity = new Entity();

        Set<Long> ids = enrich(entity);
        System.out.println((Collections.emptySet().equals(ids)));

        entity.setData(new EntityData());
        ids = enrich(entity);
        System.out.println((Collections.emptySet().equals(ids)));

        entity.getData().setPens(new ArrayList<>());
        ids = enrich(entity);
        System.out.println((Collections.emptySet().equals(ids)));

        entity.getData().getPens().add(new Pen());
        ids = enrich(entity);
        System.out.println((Collections.emptySet().equals(ids)));

        entity.getData().getPens().add(new Pen(1L, "Name1", true));
        ids = enrich(entity);
        System.out.println(ids.contains(1L));

        System.out.println(ids);
    }

    static Set<Long> enrich(Entity entity){
        return ofNullable(entity)
            .map(Entity::getData)
            .map(EntityData::getPens)
            .orElseGet(Collections::emptyList)
            .stream()
            .filter(favSkillInfo -> isTrue(favSkillInfo.getCool()))
            .map(Pen::getId)
            .collect(toSet());
    }

    static class Entity {

        private EntityData data;

        EntityData getData() {
            return data;
        }

        void setData(EntityData data) {
            this.data = data;
        }
    }

    static class EntityData {

        private List<Pen> pens;

        List<Pen> getPens() {
            return pens;
        }

        void setPens(List<Pen> pens) {
            this.pens = pens;
        }
    }

    static class Pen {

        private Long id;
        private String name;
        private Boolean cool;

        Pen() {
        }

        Pen(Long id, String name, Boolean cool) {
            this.id = id;
            this.name = name;
            this.cool = cool;
        }

        Long getId() {
            return id;
        }

        void setId(Long id) {
            this.id = id;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        Boolean getCool() {
            return cool;
        }

        void setCool(Boolean cool) {
            this.cool = cool;
        }
    }
}
