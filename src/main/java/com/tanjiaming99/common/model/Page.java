package com.tanjiaming99.common.model;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import java.util.*;
import java.util.function.Predicate;

/**
 * 简单分页模型
 *
 * @author llg
 */
@Accessors(chain = true)
@ApiModel(description = "分页数据")
@Data
@ToString
public class Page<T> implements IPage<T> {

    private static final long serialVersionUID = 1L;

    /**
     * 查询数据列表
     */
    @ApiModelProperty(value = "数据列表")
    private List<T> records = Collections.emptyList();
    /**
     * 总数
     */
    @ApiModelProperty(value = "总数")
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    @ApiModelProperty(value = "每页显示条数", required = true, example = "10")
    private long size = 10;
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页", required = true, example = "1")
    private long current = 1;

    private List<OrderItem> orders;

    private boolean optimizeCountSql;

    private boolean isSearchCount;

    private boolean hitCount;

    public Page() {
        this.records = Collections.emptyList();
        this.total = 0L;
        this.size = 10L;
        this.current = 1L;
        this.orders = new ArrayList();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        this.hitCount = false;
    }

    public Page(long current, long size) {
        this(current, size, 0L);
    }

    public Page(long current, long size, long total) {
        this(current, size, total, true);
    }

    public Page(long current, long size, boolean isSearchCount) {
        this(current, size, 0L, isSearchCount);
    }

    public Page(long current, long size, long total, boolean isSearchCount) {
        this.records = Collections.emptyList();
        this.total = 0L;
        this.size = 10L;
        this.current = 1L;
        this.orders = new ArrayList();
        this.optimizeCountSql = true;
        this.isSearchCount = true;
        this.hitCount = false;
        if (current > 1L) {
            this.current = current;
        }

        this.size = size;
        this.total = total;
        this.isSearchCount = isSearchCount;
    }

    public boolean hasPrevious() {
        return this.current > 1L;
    }

    public boolean hasNext() {
        return this.current < this.getPages();
    }

    public List<T> getRecords() {
        return this.records;
    }

    public Page<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    public long getTotal() {
        return this.total;
    }

    public Page<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public long getSize() {
        return this.size;
    }

    public Page<T> setSize(long size) {
        this.size = size;
        return this;
    }

    public long getCurrent() {
        return this.current;
    }

    public Page<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Nullable
    public String[] ascs() {
        return CollectionUtils.isNotEmpty(this.orders) ? this.mapOrderToArray(OrderItem::isAsc) : null;
    }

    private String[] mapOrderToArray(Predicate<OrderItem> filter) {
        List<String> columns = new ArrayList(this.orders.size());
        this.orders.forEach((i) -> {
            if (filter.test(i)) {
                columns.add(i.getColumn());
            }

        });
        return (String[]) columns.toArray(new String[0]);
    }

    private void removeOrder(Predicate<OrderItem> filter) {
        for (int i = this.orders.size() - 1; i >= 0; --i) {
            if (filter.test(this.orders.get(i))) {
                this.orders.remove(i);
            }
        }

    }

    public Page<T> addOrder(OrderItem... items) {
        this.orders.addAll(Arrays.asList(items));
        return this;
    }

    public Page<T> addOrder(List<OrderItem> items) {
        this.orders.addAll(items);
        return this;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Page<T> setAscs(List<String> ascs) {
        return CollectionUtils.isNotEmpty(ascs) ? this.setAsc((String[]) ascs.toArray(new String[0])) : this;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Page<T> setAsc(String... ascs) {
        this.removeOrder(OrderItem::isAsc);
        String[] var2 = ascs;
        int var3 = ascs.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            String s = var2[var4];
            this.addOrder(OrderItem.asc(s));
        }

        return this;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public String[] descs() {
        return this.mapOrderToArray((i) -> {
            return !i.isAsc();
        });
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Page<T> setDescs(List<String> descs) {
        if (CollectionUtils.isNotEmpty(descs)) {
            this.removeOrder((item) -> {
                return !item.isAsc();
            });
            Iterator var2 = descs.iterator();

            while (var2.hasNext()) {
                String s = (String) var2.next();
                this.addOrder(OrderItem.desc(s));
            }
        }

        return this;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Page<T> setDesc(String... descs) {
        this.setDescs(Arrays.asList(descs));
        return this;
    }

    public List<OrderItem> orders() {
        return this.getOrders();
    }

    public List<OrderItem> getOrders() {
        return this.orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    public boolean optimizeCountSql() {
        return this.optimizeCountSql;
    }

    public boolean isSearchCount() {
        return this.total < 0L ? false : this.isSearchCount;
    }

    public Page<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    public Page<T> setOptimizeCountSql(boolean optimizeCountSql) {
        this.optimizeCountSql = optimizeCountSql;
        return this;
    }

    public void hitCount(boolean hit) {
        this.hitCount = hit;
    }

    public boolean isHitCount() {
        return this.hitCount;
    }


}
