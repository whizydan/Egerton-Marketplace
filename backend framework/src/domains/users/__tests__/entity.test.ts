import createUserEntity from '../entities'

describe('Create new use', () => {
	it('Shoud create use', () => {
		const user = createUserEntity({
			email: 'test@gmail.com',
			password: 'pass',
			userName: 'testUname'
		})
		expect(user).toBeDefined()
		expect(user.getEmail()).toBe('test@gmail.com')
		expect(user.getEmail()).toMatchInlineSnapshot('"test@gmail.com"')
	})
	it('Should not create a user', () => {
		try {
			createUserEntity({
				email: 'test@gmail.com',
				password: '',
				userName: 'test user'
			})
		} catch (error) {
			expect(error).toBeDefined()
		}
	})
	it('Should not create a user', () => {
		try {
			createUserEntity({
				email: '',
				password: 'somePass',
				userName: 'test user'
			})
		} catch (error) {
			expect(error).toBeDefined()
		}
	})
	it('Should not create a user', () => {
		try {
			createUserEntity({
				email: 'test@gmail.com',
				password: 'pass',
				userName: ''
			})
		} catch (error) {
			expect(error).toBeDefined()
		}
	})
})
