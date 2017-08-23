package com.javarush.test.level23.lesson04.home01;

import java.util.List;
import java.util.Map;

/* Inner 3
Внутри класса Solution:
1) реализуйте private class TaskDataProvider используя Task и DbMock, цель которого - обновить поле tasks.
2) реализуйте private class NameDataProvider используя String и DbMock, цель которого - обновить поле names.
*/
public class Solution {

    public static void main(String[] args) {
        new Solution().refresh();
    }

    private class TaskDataProvider implements DbDataProvider<Task>{
        public void refreshAllData(Map criteria) {
            Solution.this.tasks = new DbMock().getFakeTasks(criteria);
        }
    }
    private class NameDataProvider implements DbDataProvider<String> {
        public void refreshAllData(Map criteria) {
            Solution.this.names = new DbMock().getFakeNames(criteria);
        }
    }

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }



    class Task {
    }
}