Ext.require([
    'AIDRFM.common.AIDRFMFunctions',
    'AIDRFM.common.StandardLayout',
    'AIDRFM.common.Header',
    'AIDRFM.common.Footer'
]);

Ext.define('ADMIN.health.view.AdminHealthPanel', {
    extend: 'AIDRFM.common.StandardLayout',
    alias: 'widget.admin-health-view',

    initComponent: function () {
        var me = this;

        this.breadcrumbs = Ext.create('Ext.container.Container', {
            html: '<div class="bread-crumbs">' +
                '<a href="' + BASE_URL + '/protected/home">AIDR</a><span>&nbsp;&gt;&nbsp;' +
                '<a href="' + BASE_URL + '/protected/administration/admin-console">Administrator console</a><span>&nbsp;&gt;&nbsp;' +
                'System health</span></div>',
            margin: 0,
            padding: 0
        });

        this.collectorLabel = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            text: 'My Collections',
            width: 150
        });

        this.collectorStatus = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            flex: 1
        });

        this.taggerLabel = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            text: 'My Classifiers',
            width: 150
        });

        this.taggerStatus = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            flex: 1
        });

        this.trainerLabel = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            text: 'Trainer',
            width: 150
        });

        this.trainerStatus = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            flex: 1
        });

        this.AIDROutputLabel = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            text: 'Output',
            width: 150
        });

        this.AIDROutputStatus = Ext.create('Ext.form.Label', {
            cls: 'styled-text',
            flex: 1
        });

        this.pageTitle = Ext.create('Ext.form.Label', {
            cls: 'header-h1 bold-text',
            text: 'System health',
            flex: 1
        });

        this.items = [
            this.breadcrumbs,
            {
                xtype: 'container',
                margin: '5 0 5 0',
                html: '<div class="horizontalLine"></div>'
            },
            this.pageTitle,
            {
                xtype: 'container',
                margin: '5 0 0 0',
                layout: 'hbox',
                items: [
                    this.collectorLabel,
                    this.collectorStatus
                ]
            },{
                xtype: 'container',
                margin: '15 0 0 0',
                layout: 'hbox',
                items: [
                    this.taggerLabel,
                    this.taggerStatus
                ]
            },{
                xtype: 'container',
                margin: '15 0 0 0',
                layout: 'hbox',
                items: [
                    this.trainerLabel,
                    this.trainerStatus
                ]
            },{
                xtype: 'container',
                margin: '15 0 0 0',
                layout: 'hbox',
                items: [
                    this.AIDROutputLabel,
                    this.AIDROutputStatus
                ]
            }
        ];

        this.callParent(arguments);
    }

});