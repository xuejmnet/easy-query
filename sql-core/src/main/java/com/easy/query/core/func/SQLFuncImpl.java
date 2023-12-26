package com.easy.query.core.func;

import com.easy.query.core.expression.lambda.SQLExpression1;
import com.easy.query.core.expression.parser.core.SQLTableOwner;
import com.easy.query.core.expression.parser.core.available.TableAvailable;
import com.easy.query.core.func.column.ColumnExpression;
import com.easy.query.core.func.column.ColumnFuncSelector;
import com.easy.query.core.func.column.ColumnFuncSelectorImpl;
import com.easy.query.core.func.def.DistinctDefaultSQLFunction;
import com.easy.query.core.func.def.enums.DateTimeDurationEnum;
import com.easy.query.core.func.def.enums.DateTimeUnitEnum;
import com.easy.query.core.func.def.impl.AbsSQLFunction;
import com.easy.query.core.func.def.impl.AvgSQLFunction;
import com.easy.query.core.func.def.impl.CastSQLFunction;
import com.easy.query.core.func.def.impl.DateTimeCompareToSQLFunction;
import com.easy.query.core.func.def.impl.StringCompareToSQLFunction;
import com.easy.query.core.func.def.impl.ConcatSQLFunction;
import com.easy.query.core.func.def.impl.CountSQLFunction;
import com.easy.query.core.func.def.impl.DateTimeDurationSQLFunction;
import com.easy.query.core.func.def.impl.DateTimeFormatSQLFunction;
import com.easy.query.core.func.def.impl.DateTimePlusMonthSQLFunction;
import com.easy.query.core.func.def.impl.DateTimePlusSQLFunction;
import com.easy.query.core.func.def.impl.DateTimePlusYearSQLFunction;
import com.easy.query.core.func.def.impl.DateTimePropertySQLFunction;
import com.easy.query.core.func.def.impl.DateTimeSQLFormatSQLFunction;
import com.easy.query.core.func.def.impl.JoinSQLFunction;
import com.easy.query.core.func.def.impl.LengthSQLFunction;
import com.easy.query.core.func.def.impl.MaxSQLFunction;
import com.easy.query.core.func.def.impl.MinSQLFunction;
import com.easy.query.core.func.def.impl.NowSQLFunction;
import com.easy.query.core.func.def.impl.NullDefaultSQLFunction;
import com.easy.query.core.func.def.impl.LeftPadSQLFunction;
import com.easy.query.core.func.def.impl.RightPadSQLFunction;
import com.easy.query.core.func.def.impl.ReplaceSQLFunction;
import com.easy.query.core.func.def.impl.RoundSQLFunction;
import com.easy.query.core.func.def.impl.SubStringSQLFunction;
import com.easy.query.core.func.def.impl.SumSQLFunction;
import com.easy.query.core.func.def.impl.ToLowerSQLFunction;
import com.easy.query.core.func.def.impl.ToUpperSQLFunction;
import com.easy.query.core.func.def.impl.TrimEndSQLFunction;
import com.easy.query.core.func.def.impl.TrimSQLFunction;
import com.easy.query.core.func.def.impl.TrimStartSQLFunction;
import com.easy.query.core.func.def.impl.UtcNowSQLFunction;
import com.easy.query.core.util.EasyObjectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * create time 2023/10/5 22:23
 * 文件说明
 *
 * @author xuejiaming
 */
public class SQLFuncImpl implements SQLFunc {
    protected TableAvailable getTable(SQLTableOwner tableOwner) {
        return EasyObjectUtil.getValueOrNull(tableOwner, SQLTableOwner::getTable);
    }

    protected List<ColumnExpression> getColumnExpressions(SQLExpression1<ColumnFuncSelector> sqlExpression){
        List<ColumnExpression> columnExpressions = new ArrayList<>();
        sqlExpression.apply(new ColumnFuncSelectorImpl(columnExpressions));
        return columnExpressions;
    }
    @Override
    public DistinctDefaultSQLFunction sum(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new SumSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public DistinctDefaultSQLFunction count(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new CountSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction max(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new MaxSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction min(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new MinSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction toLower(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new ToLowerSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction toUpper(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new ToUpperSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction subString(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new SubStringSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public DistinctDefaultSQLFunction avg(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new AvgSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction valueOrDefault(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        List<ColumnExpression> columnExpressions = new ArrayList<>();
        sqlExpression.apply(new ColumnFuncSelectorImpl(columnExpressions));
        return new NullDefaultSQLFunction(columnExpressions);
    }

    @Override
    public SQLFunction abs(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new AbsSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction round(SQLTableOwner tableOwner, String property, int scale) {
        return new RoundSQLFunction(getTable(tableOwner), property, scale);
    }

    @Override
    public SQLFunction dateTimeFormat(SQLTableOwner tableOwner, String property, String javaFormat) {
        return new DateTimeFormatSQLFunction(getTable(tableOwner), property, javaFormat);
    }

    @Override
    public SQLFunction dateTimeSQLFormat(SQLTableOwner tableOwner, String property, String format) {
        return new DateTimeSQLFormatSQLFunction(getTable(tableOwner), property, format);
    }

    @Override
    public SQLFunction concat(List<ColumnExpression> concatExpressions) {
        return new ConcatSQLFunction(concatExpressions);
    }

//    @Override
//    public SQLFunction join(String separator, List<ColumnExpression> concatExpressions) {
//        return new StringJoinSQLFunction(separator, concatExpressions);
//    }

    @Override
    public SQLFunction now() {
        return NowSQLFunction.INSTANCE;
    }

    @Override
    public SQLFunction utcNow() {
        return UtcNowSQLFunction.INSTANCE;
    }

    @Override
    public SQLFunction trim(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new TrimSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction trimStart(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new TrimStartSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction trimEnd(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new TrimEndSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction replace(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new ReplaceSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction stringCompareTo(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new StringCompareToSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction leftPad(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new LeftPadSQLFunction(getColumnExpressions(sqlExpression));
    }
    @Override
    public SQLFunction rightPad(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new RightPadSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction join(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new JoinSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction length(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new LengthSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction cast(SQLExpression1<ColumnFuncSelector> sqlExpression, Class<?> targetClazz) {
        return new CastSQLFunction(getColumnExpressions(sqlExpression),targetClazz);
    }

    @Override
    public SQLFunction plusDateTime(SQLExpression1<ColumnFuncSelector> sqlExpression, long duration, TimeUnit timeUnit) {
        return new DateTimePlusSQLFunction(getColumnExpressions(sqlExpression),duration,timeUnit);
    }

    @Override
    public SQLFunction plusDateTimeMonths(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new DateTimePlusMonthSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction plusDateTimeYears(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new DateTimePlusYearSQLFunction(getColumnExpressions(sqlExpression));
    }

    @Override
    public SQLFunction dateTimeProperty(SQLExpression1<ColumnFuncSelector> sqlExpression, DateTimeUnitEnum dateTimeUnitEnum) {
        return new DateTimePropertySQLFunction(getColumnExpressions(sqlExpression),dateTimeUnitEnum);
    }

    @Override
    public SQLFunction duration(SQLExpression1<ColumnFuncSelector> sqlExpression, DateTimeDurationEnum durationEnum) {
        return new DateTimeDurationSQLFunction(getColumnExpressions(sqlExpression),durationEnum);
    }

    @Override
    public SQLFunction dateTimeCompareTo(SQLExpression1<ColumnFuncSelector> sqlExpression) {
        return new DateTimeCompareToSQLFunction(getColumnExpressions(sqlExpression));
    }
}
