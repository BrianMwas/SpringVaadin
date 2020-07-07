package com.briandev.springvaadin.ui

import com.briandev.springvaadin.backend.models.Tasks
import com.briandev.springvaadin.backend.services.TaskService
import com.github.mvysny.karibudsl.v10.*
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.data.provider.DataProvider
import com.vaadin.flow.data.provider.ListDataProvider
import com.vaadin.flow.router.Route

@Route("home")
class MainView(private val tasksService: TaskService) : KComposite() {
    val tasks = tasksService.getTasks()
    private var taskGrid: Grid<Tasks> = Grid(Tasks::class.java)
    private val root = ui {
        verticalLayout {
            setSizeFull()
            addClassName("list-view")
            taskGrid.dataProvider = ListDataProvider(tasksService.getTasks())
            configureGrid()

            add(taskGrid)
        }
    }
    init {
        initGrid()
    }



    private fun initGrid() {
        taskGrid.setItems(tasksService.getTasks())
    }

    private fun configureGrid() {
        taskGrid.addClassName("contact-grid")
        taskGrid.setSizeFull()
        taskGrid.setColumns(
                "title",
            "description",
            "status",
            "priority",
            "startDate",
            "dueDate"
        )
    }
}