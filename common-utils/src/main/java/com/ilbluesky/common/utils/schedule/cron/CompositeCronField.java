package com.ilbluesky.common.utils.schedule.cron;

import com.ilbluesky.common.utils.test.Asserts;

import javax.annotation.Nullable;
import java.time.temporal.Temporal;

/**
 * @author Orca Zhang
 * date 1/13/2025
 */
final class CompositeCronField extends CronField {

    private final CronField[] fields;

    private final String value;


    private CompositeCronField(Type type, CronField[] fields, String value) {
        super(type);
        this.fields = fields;
        this.value = value;
    }

    /**
     * Composes the given fields into a {@link CronField}.
     */
    public static CronField compose(CronField[] fields, Type type, String value) {
        Asserts.notEmpty(fields, "Fields must not be empty");
        Asserts.hasLength(value, "Value must not be empty");

        if (fields.length == 1) {
            return fields[0];
        }
        else {
            return new CompositeCronField(type, fields, value);
        }
    }


    @Nullable
    @Override
    public <T extends Temporal & Comparable<? super T>> T nextOrSame(T temporal) {
        T result = null;
        for (CronField field : this.fields) {
            T candidate = field.nextOrSame(temporal);
            if (result == null ||
                    candidate != null && candidate.compareTo(result) < 0) {
                result = candidate;
            }
        }
        return result;
    }


    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompositeCronField)) {
            return false;
        }
        CompositeCronField other = (CompositeCronField) o;
        return type() == other.type() &&
                this.value.equals(other.value);
    }

    @Override
    public String toString() {
        return type() + " '" + this.value + "'";

    }
}